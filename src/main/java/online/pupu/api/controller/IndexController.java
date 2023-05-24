package online.pupu.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.config.MqttGateway;
import online.pupu.api.service.user.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import utils.Result;

import java.util.Random;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    private final MqttGateway mqttGateway;



    @GetMapping("/index")
    Result index(String id) {

        mqttGateway.sendToMqtt(id, id  + "=" + RandomStringUtils.randomAlphanumeric(5));

        return Result.success("3");
    }


    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
}
