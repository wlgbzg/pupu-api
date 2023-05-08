package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import utils.Result;

/**
 * 好友
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/friend")
public class FriendController {

    /**
     * 创建一个行会
     */
    @PostMapping("/")
    Result create() {
        return Result.success();
    }

    /**
     * 获取行会成员分页列表
     */
    @PostMapping("/users/{guideId}")
    Result messages(@PathVariable("guideId") String guideId, Integer offset, Integer limit) {
        return Result.success();
    }
}
