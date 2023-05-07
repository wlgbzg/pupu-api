package online.pupu.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResult {
    private String id;
    private String token;
    private boolean profileComplete;
}
