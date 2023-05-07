package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.Result;

/**
 * 行会
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/guides")
public class GuidesController {

    /**
     * 创建一个行会
     * name/icon
     */
    @GetMapping("/")
    Result messages(@PathVariable String channelId, Integer limit) {
        return Result.success();
    }

}
