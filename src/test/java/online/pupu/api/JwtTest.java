package online.pupu.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.HashMap;

public class JwtTest {
    // 秘钥，你可以随便取，可以取的难一点
    public static final String SECRET = "ASD!@#F^%A";

    public void testTokenCreate() {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("kk", "32s");
        // 过期时间，60s
        Calendar expires = Calendar.getInstance();
        expires.add(Calendar.SECOND, 600);

        String jwtToken = JWT.create()
                // 第一部分Header
                .withHeader(headers)
                // 第二部分Payload
                .withClaim("userId", 202)
                .withClaim("userName", "2LJJ")
                .withExpiresAt(expires.getTime())
                // 第三部分Signature
                .sign(Algorithm.HMAC256(SECRET));
        System.out.println(jwtToken);
    }
}
