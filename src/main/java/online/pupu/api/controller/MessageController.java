package online.pupu.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.config.ApiFailedException;
import online.pupu.api.config.MqttGateway;
import online.pupu.api.model.Message;
import online.pupu.api.request.MessageList;
import online.pupu.api.request.MessageSend;
import online.pupu.api.service.channel.ChannelService;
import online.pupu.api.service.message.MessageService;
import online.pupu.api.service.user.UserService;
import org.springframework.web.bind.annotation.*;
import utils.BeanUtilsV2;
import utils.Result;

import java.util.List;

/**
 * 发送消息
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/message")
public class MessageController {

    private final ChannelService channelService;
    private final MessageService messageService;
    private final UserService userService;
    private final MqttGateway mqttGateway;
    private final ObjectMapper objectMapper;

    /**
     * 发送消息
     */
    @PostMapping("/channel/send")
    Result sendMessage(@RequestHeader String id, @RequestBody MessageSend r) {
        String mId = messageService.generateId();
        Message m = new Message();
        m.setId(mId);
        m.setFrom(id);
        m.setTime(System.currentTimeMillis());
        BeanUtilsV2.copyProperties(r, m);
        m = messageService.save(m);
        m.setUser(userService.findById(m.getFrom()));

        try {
            mqttGateway.sendToMqtt("channel-" + r.getChannelId(), objectMapper.writeValueAsString(m));
        } catch (JsonProcessingException e) {
            throw new ApiFailedException("send to mqtt");
        }
        return Result.success(m);
    }

    /**
     * 发送消息
     */
    @PostMapping("/channel/messageList")
    Result messageList(@RequestHeader String id, @RequestBody MessageList r) {
        List<Message> message = messageService.findMessage(r.getChannelId(), r.getTime());
        message.forEach(m -> {
            m.setUser(userService.findById(m.getFrom()));
        });
        return Result.success(message);
    }

}
