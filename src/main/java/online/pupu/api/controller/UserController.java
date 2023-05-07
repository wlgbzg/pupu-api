package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.model.User;
import online.pupu.api.request.UserUpdate;
import online.pupu.api.service.user.UserService;
import org.springframework.web.bind.annotation.*;
import utils.BeanUtilsV2;
import utils.Result;

/**
 * 用户
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    /**
     * 获取自己的资料
     */
    @PostMapping("/profile")
    Result profile(@RequestHeader String id) {
        return Result.success(userService.findById(id));
    }

    /**
     * 修改用户资料
     * avatar、name
     */
    @PostMapping("/update")
    Result update(@RequestHeader String id, @RequestBody UserUpdate r) {
        User user = userService.findById(id);
        BeanUtilsV2.copyPropertiesIgnoreNull(r, user);
        user.setProfileComplete(true);
        user = userService.save(user);
        return Result.success(user);
    }


}
