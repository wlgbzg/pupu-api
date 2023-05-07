package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import utils.Result;

/**
 * 频道
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/channels")
public class ChannelsController {

    /**
     * 获取频道历史消息
     */
    @GetMapping("/{channelId}/messages")
    Result messages(@PathVariable("channelId") String channelId, Integer limit) {
        return Result.success();
    }

}
