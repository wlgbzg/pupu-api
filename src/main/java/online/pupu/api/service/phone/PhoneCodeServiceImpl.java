package online.pupu.api.service.phone;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PhoneCodeServiceImpl implements PhoneCodeService {

    private static final String prefix = "PhoneCode";

    private static final Duration timeout = Duration.ofMinutes(5);

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void send(PhoneCodeType type, String phone, String phonePrefix) {
        String code = "111111";
        String key = StringUtils.joinWith("_", prefix, type, phonePrefix, phone);
        stringRedisTemplate.opsForValue().set(key, code, timeout);
    }

    @Override
    public boolean verify(PhoneCodeType type, String phone, String phonePrefix, String verifyCode) {
        String key = StringUtils.joinWith("_", prefix, type, phonePrefix, phone);
        boolean verify = Objects.equals(stringRedisTemplate.opsForValue().get(key), verifyCode);
        if (verify) {
            stringRedisTemplate.delete(key);
        }
        return verify;
    }
}
