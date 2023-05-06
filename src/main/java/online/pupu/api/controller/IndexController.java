package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.model.User;
import online.pupu.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import utils.Result;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;

    @GetMapping("/index")
    Result index() {

        log.warn("警告3");
        log.error("错误4");


//        User u = userService.save(User.builder().name("名字: " + UUID.randomUUID()).build());
        return Result.success("3");
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
}
