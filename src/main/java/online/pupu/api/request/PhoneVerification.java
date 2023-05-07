package online.pupu.api.request;

import lombok.Data;

@Data
public class PhoneVerification {
    private String phone;
    private String phonePrefix;
}
