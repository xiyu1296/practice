package xiyu1296.tlias.utils;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class jwtutils {
    private static final String key = "xiyu1296";
    private static final long time = 4320000L;

    public static String generateJwt(Map<String, Object> claims) {

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .compact();
    }

    public static Claims parseJwt(String Jwt) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(Jwt)
                .getBody();
    }
}
