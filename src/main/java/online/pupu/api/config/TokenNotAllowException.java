package online.pupu.api.config;

public class TokenNotAllowException extends RuntimeException {
    public TokenNotAllowException(String message) {
        super(message);
    }
}
