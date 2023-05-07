package online.pupu.api.request;

import lombok.Data;

@Data
public class VerifyCodeLogin {
    private String phone;
    private String phonePrefix;
    private String verifyCode;
}
