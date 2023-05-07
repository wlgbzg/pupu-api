package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.config.ApiFailedException;
import online.pupu.api.model.User;
import online.pupu.api.request.PasswordLogin;
import online.pupu.api.request.PhoneVerification;
import online.pupu.api.request.VerifyCodeLogin;
import online.pupu.api.response.LoginResult;
import online.pupu.api.service.phone.PhoneCodeService;
import online.pupu.api.service.phone.PhoneCodeType;
import online.pupu.api.service.user.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;
import online.pupu.api.config.MessageUtils;
import utils.PhoneUtils;
import utils.Result;
import utils.jwt.JwtUtils;
import java.util.Objects;

/**
 * 注册登录
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final PhoneCodeService phoneCodeService;

    /**
     * 发送手机验证码
     */
    @PostMapping("/phone-verification")
    Result phoneVerification(@RequestBody PhoneVerification r) {
        phoneCodeService.send(PhoneCodeType.Login, r.getPhone(), r.getPhonePrefix());
        return Result.success();
    }

    /**
     * 通过手机号验证码注册 or 登录
     */
    @PostMapping("/verify-code-login")
    Result verifyCodeLogin(@RequestBody VerifyCodeLogin r) {
        boolean verify = phoneCodeService.verify(PhoneCodeType.Login, r.getPhone(), r.getPhonePrefix(), r.getVerifyCode());
        if (!verify) {
            throw new ApiFailedException(MessageUtils.message("verify.code.error"));
        }

        // 通过手机号验证码登录
        User user = userService.findByPhone(r.getPhone());
        if (user != null) {
            String token = JwtUtils.create(user.getId());
            return Result.success(new LoginResult(user.getId(), token, user.isProfileComplete()));
        }

        // 注册新用户
        String id = userService.generateUserId();
        user = userService.save(User.builder().id(id).name(PhoneUtils.hideMiddle(r.getPhone())).phone(r.getPhone()).phonePrefix(r.getPhonePrefix()).createTime(System.currentTimeMillis()).build());
        String token = JwtUtils.create(user.getId());
        return Result.success(new LoginResult(id, token, true));
    }

    /**
     * 通过密码登录
     */
    @PostMapping("/password-login")
    Result passwordLogin(@RequestBody PasswordLogin r) {
        User user = userService.findByPhone(r.getPhone());
        if (user != null && Objects.equals(user.getPassword(), DigestUtils.md5Hex(r.getPassword()))) {
            String token = JwtUtils.create(user.getId());
            return Result.success(new LoginResult(user.getId(), token, false));
        }
        throw new ApiFailedException(MessageUtils.message("verify.password.error"));
    }
}
