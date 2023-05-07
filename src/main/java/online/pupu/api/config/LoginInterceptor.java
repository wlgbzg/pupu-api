package online.pupu.api.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.jwt.JwtResult;
import utils.jwt.JwtUtils;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (verify(request)) {
            throw new TokenNotAllowException(MessageUtils.message("not.authorized"));
        }
        return true;
    }

    private boolean verify(HttpServletRequest request) {
        String authorization = request.getHeader("authorization");
        String id = request.getHeader("id");
        if (!StringUtils.hasLength(authorization) || !StringUtils.hasLength(id)) {
            return false;
        }
        JwtResult result = JwtUtils.verify(authorization);
        return result.isOk() && Objects.equals(id, result.getId());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
