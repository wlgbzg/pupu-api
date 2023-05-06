package utils.jwt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResult {
    private boolean ok;
    private String id;
}
