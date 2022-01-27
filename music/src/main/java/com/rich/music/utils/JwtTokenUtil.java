package com.rich.music.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dock
 * @CreateTime: 2022/1/26
 * @Description: JwtToken工具类
 */
@Component
public class JwtTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    // 将用户名和创建时间放入JWT的荷载头中
    public static final String CLAIM_KEY_USERNAME = "sub";
    public static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;


    /**
     * 根据用户生成Token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);//生成token
    }

    /**
     * 从Token中获取登录用户名
     * @return
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);//从token中获取荷载
            username = claims.getSubject();//通过荷载获取用户名
        } catch (Exception e) {
            username = null;//如果有异常,用户名就是空的
        }
        return username;
    }



    /**
     * 验证token是否有效(用户名和userDetails中的用户名是否一致,token是否过期)
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token,UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpiration(token);
    }

    /**
     * 判断token是否可以被刷新(过期了可以被刷新)
     * @param token
     * @return
     */
    public boolean canRefresh(String token) {
        return !isTokenExpiration(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }



    /**
     * 内部方法：判断Token是否失效
     * @param token
     * @return
     */
    private boolean isTokenExpiration(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 内部方法 : 从token中获取过期时间
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 内部方法 : 从token中获取荷载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 内部方法 : 根据荷载生成token
     * @param claims
     * @return
     */
    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpiration())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 内部方法 : 生成token失效时间
     * @return
     */
    private Date generateExpiration() {
        return new Date(System.currentTimeMillis() + expiration * 1000 );
    }






}
