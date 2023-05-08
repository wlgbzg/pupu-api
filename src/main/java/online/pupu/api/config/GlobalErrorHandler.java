package online.pupu.api.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import utils.Result;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e) {
        log.error("handlerException", e);
        return Result.error(500, "server error");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handlerMethodArgumentNotValidException() {
        return Result.error(400, "MethodArgumentNotValidException");
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public Result handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return Result.error(400, e.getMessage());
    }

    @ExceptionHandler(value = TokenNotAllowException.class)
    public Result handlerTokenNotAllowException(TokenNotAllowException e) {
        return Result.error(403, e.getMessage());
    }

    @ExceptionHandler(value = ApiFailedException.class)
    public Result handlerApiFailedException(ApiFailedException e) {
        return Result.error(401, e.getMessage());
    }

}
