package utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtils {
    public static final String SECRET = "PU!@#F^%pu";

    private static final String CLAIM_ID = "id";

    public static String create(String id) {
        Calendar expires = Calendar.getInstance();
        expires.add(Calendar.YEAR, 100);
        return JWT.create()
                .withHeader(Map.of("k", 1))
                .withClaim(CLAIM_ID, id)
                .withExpiresAt(expires.getTime())
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static JwtResult verify(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JwtUtils.SECRET)).build();
            DecodedJWT verify = jwtVerifier.verify(token);
            return JwtResult.builder().ok(true).id(verify.getClaim(CLAIM_ID).asString()).build();
        } catch (Exception ignored) {
        }
        return JwtResult.builder().ok(false).build();
    }
}
