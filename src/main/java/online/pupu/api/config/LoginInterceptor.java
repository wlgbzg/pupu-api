package online.pupu.api.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.MessageUtils;
import utils.jwt.JwtResult;
import utils.jwt.JwtUtils;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("authorization");
        String id = request.getHeader("id");
        if (!StringUtils.hasLength(authorization) || !StringUtils.hasLength(id)) {
            throw new TokenNotAllowException(MessageUtils.message("not.authorized"));
        }
        JwtResult result = JwtUtils.verify(authorization.replace("Bearer ", ""));
        if (!result.isOk() || !Objects.equals(id, result.getId())) {
            throw new TokenNotAllowException(MessageUtils.message("not.authorized"));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
