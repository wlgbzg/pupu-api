package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.model.Channel;
import online.pupu.api.request.ChannelCreate;
import online.pupu.api.service.channel.ChannelService;
import org.springframework.web.bind.annotation.*;
import utils.Result;

/**
 * 频道
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/channel")
public class ChannelController {

    private final ChannelService channelService;

    /**
     * 获取频道历史消息
     */
    @GetMapping("/{channelId}/messages")
    Result messages(@PathVariable("channelId") String channelId, Integer limit) {
        return Result.success();
    }


    /**
     * 创建一个频道
     */
    @PostMapping("/create")
    Result create(@RequestHeader String id, @RequestBody ChannelCreate r) {
        String channelId = channelService.generateId();

        Channel channel = new Channel();
        channel.setId(channelId);
        channel.setCreateTime(System.currentTimeMillis());
        channel.setGuildId(r.getGuildId());
        channel.setName(r.getName());
        channel.setReadonly(false);
        channel.setType(r.getType());
        channel.setIsPrivate(false);
        channel = channelService.saveChannel(channel);
        return Result.success(channel);
    }
}
