package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.config.MessageUtils;
import online.pupu.api.service.app.AppConfig;
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
     * app配置
     */
    @PostMapping("/config")
    Result create() {
        AppConfig config = new AppConfig();
        config.setAppName(MessageUtils.message("app.config.appName"));
        config.setWelcomeSubTitle(MessageUtils.message("app.config.welcome.sub.title"));
        config.setWelcomeTitle(MessageUtils.message("app.config.welcome.title"));
        return Result.success(config);
    }

}
