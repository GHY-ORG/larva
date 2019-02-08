package cn.ghy.larva.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author Ziyang
 */
@Component
public class TokenUtil implements Serializable {

  private String secretKey = "iamghyer";

  private String generateToken(Map<String, Object> claims) {
    Date expirationDate = new Date(System.currentTimeMillis() + 3600L * 1000);
    return Jwts.builder()
        .setClaims(claims)
        .setExpiration(expirationDate)
        .signWith(SignatureAlgorithm.HS512, secretKey)
        .compact();
  }

  private Claims getClaimsFromToken(String token) {
    Claims claims;
    try {
      claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    } catch (Exception e) {
      claims = null;
    }
    return claims;
  }

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>(2);
    claims.put("created", new Date());
    return generateToken(claims);
  }

  public String getUsernameFromToken(String token) {
    String username;
    try {
      Claims claims = getClaimsFromToken(token);
      username = claims.getSubject();
    } catch (Exception e) {
      username = null;
    }
    return username;
  }

  public Boolean isTokenExpired(String token) {
    try {
      Claims claims = getClaimsFromToken(token);
      Date expiration = claims.getExpiration();
      return expiration.before(new Date());
    } catch (Exception e) {
      return false;
    }
  }

  public String refreshToken(String token) {
    String refreshedToken;
    try {
      Claims claims = getClaimsFromToken(token);
      claims.put("created", new Date());
      refreshedToken = generateToken(claims);
    } catch (Exception e) {
      refreshedToken = null;
    }
    return refreshedToken;
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    User user = (User) userDetails;
    String username = getUsernameFromToken(token);
    return (username.equals(user.getUsername()) && !isTokenExpired(token));
  }
}