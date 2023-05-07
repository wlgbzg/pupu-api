package online.pupu.api.request;

import lombok.Data;

@Data
public class PasswordLogin {
    private String phone;
    private String password;
}
