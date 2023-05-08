package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.config.MessageUtils;
import online.pupu.api.service.app.LoginConfig;
import org.springframework.web.bind.annotation.*;
import utils.Result;

/**
 * app
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/app")
public class AppController {

    /**
     * 登录配置
     */
    @PostMapping("/config/login")
    Result create() {
        LoginConfig config = new LoginConfig();
        config.setSubTitle(MessageUtils.message("app.config.login.sub.title"));
        config.setTitle(MessageUtils.message("app.config.login.title"));
        return Result.success(config);
    }

}
