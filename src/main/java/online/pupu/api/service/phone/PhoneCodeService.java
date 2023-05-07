package online.pupu.api.service.phone;

public interface PhoneCodeService {

    void send(PhoneCodeType type, String phone, String phonePrefix);

    boolean verify(PhoneCodeType type, String phone, String phonePrefix, String verifyCode);
}
