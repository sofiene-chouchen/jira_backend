package com.jirademo.jiraapi.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {


  private static final String SECRET_KEY = "Nq9QrLJEIq8/30ynCA-MAcXPIUGg/lTIugYFsMZITWL3C5h6EhIlHU65kQ=Yv9Cd4R9xfZV0C1yj09mfKPZ7lWUeDo04NQ2Hz=?!fXz3TFXtum5z=qRp1ZINF=evdoCc4h?CVL8nyEkK/NITVZYrPrvp6HVVcV?=QO2XW?l/2yQz2OZTgFw-/u0jSodSSGif=10LGvM1DI75DzG9hcSNQKRxlik48LW3mlgVH6W!eFBK!vbZHzVV6/mjaYySjDSf\n";
  public String extractEmail(String token) {
    return exctractClaim(token , Claims::getSubject);
  }
  public <T> T exctractClaim(String token , Function<Claims , T> claimsResolver ){
    final Claims claims = extracAlltClaims(token);
    return claimsResolver.apply(claims);
  }
  private Claims extracAlltClaims(String token){
    return Jwts
    .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
  }

  private Key getSignInKey() {
    byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(KeyBytes);
  }



  //? Genrate a token
  public String genrateToken(
          Map<String , Object > extraClaims ,
          UserDetails userDetails

  ){
    return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 ))//! the date of expire token
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact(); //? generate and return the token
  }

}
