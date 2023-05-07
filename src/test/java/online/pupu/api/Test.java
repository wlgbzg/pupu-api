package online.pupu.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.service.phone.PhoneCodeType;
import org.apache.commons.lang3.StringUtils;
import utils.PhoneUtils;
import utils.jwt.JwtResult;
import utils.jwt.JwtUtils;

@Slf4j
public class Test {
    public static void main(String[] args) {
        System.out.println(StringUtils.joinWith("_", PhoneCodeType.Login,"1","2"));
    }
}
