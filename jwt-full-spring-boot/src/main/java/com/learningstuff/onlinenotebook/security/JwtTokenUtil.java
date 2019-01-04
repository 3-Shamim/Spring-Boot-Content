package com.learningstuff.onlinenotebook.security;

import com.learningstuff.onlinenotebook.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import static sun.audio.AudioDevice.device;

@Component
public class JwtTokenUtil {

    private Clock clock = DefaultClock.INSTANCE;

    public String getUsernameFromToken(String authToken) {
        return getAllClaimsFromToken(authToken).getSubject();
    }

    public Date getIssuedDateFromToken(String token) {
        return getAllClaimsFromToken(token).getIssuedAt();
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

//    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }

    private Claims getAllClaimsFromToken(String token) {

        return Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();

    }

    private boolean isTokenExpired(String authToken) {
        Date expiration = getExpirationDateFromToken(authToken);
        return expiration.before(clock.now());
    }

    private boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordResetDate) {
        return lastPasswordResetDate != null && created.before(lastPasswordResetDate);
    }

    public boolean validateToken(String authToken, UserDetails userDetails) {

        User user = (User) userDetails;
        String username = getUsernameFromToken(authToken);
        Date created = getIssuedDateFromToken(authToken);
        return username.equals(user.getEmail()) && !isTokenExpired(authToken) && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate());
    }

    public String generateToken(UserDetails userDetails) {

//        Date createdDate = clock.now();

        Date createdDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        Date expirationDate = calculateExpirationDate(createdDate);

        System.out.println(createdDate);
        System.out.println(expirationDate);

        Claims claims = Jwts.claims()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }

    private Date calculateExpirationDate(Date createdDate) {

//        return new Date(createdDate.getTime() * SecurityConstants.EXPIRATION_TIME);

        LocalDateTime dateTime = LocalDateTime.ofInstant(createdDate.toInstant(), ZoneId.systemDefault());

        return Date.from(dateTime.plusMinutes(2).atZone(ZoneId.systemDefault()).toInstant());
    }


    public String refreshedToken(String token) {


        Date createdDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        Date expirationDate = calculateExpirationDate(createdDate);

        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate)
                .setExpiration(expirationDate);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();

    }
}
