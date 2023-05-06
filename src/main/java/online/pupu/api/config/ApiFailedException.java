package online.pupu.api.config;

public class ApiFailedException extends RuntimeException {
    public ApiFailedException(String message) {
        super(message);
    }
}
