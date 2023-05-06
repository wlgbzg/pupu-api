package online.pupu.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import utils.jwt.JwtResult;
import utils.jwt.JwtUtils;

@Slf4j
public class Test {
    public static void main(String[] args) {
      log.info("测试1");

        String token = JwtUtils.create("3");
        JwtResult r =JwtUtils.verify(token);

        System.out.println(r);
//
//        System.out.println(JwtUtils.create("3"));
//
////         new JwtTest().testTokenCreate();
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JwtUtils.SECRET)).build();
//        DecodedJWT verify = jwtVerifier.verify("eyJmIjoxLCJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjMiLCJleHAiOjE2ODMzNTk3Njl9.hU6OHvETDhJijCAUNVblDtOa-LkKLcq5fWNjaZ_jCXk");
//
//        System.out.println("过期? :"  + verify.getHeader());
//        System.out.println(verify.getClaim("id").asString());
//        System.out.println("过期时间：" + verify.getExpiresAt());

//         "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjIwLCJ1c2VyTmFtZSI6IkxKSiIsImV4cCI6MTY4MzM1OTEyN30.tVlziUR4QfnG19PRBl4DBJ8nhpykRGAIHcQ_dFkH_00"
//        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjIwLCJ1c2VyTmFtZSI6IkxKSiIsImV4cCI6MTY4MzM1OTEzOH0.t0bWd4rCILPCIStFgYIpV4hgtr53761yQzmfmdva4lc"
    }
}
