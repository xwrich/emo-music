package com.rich.music;

import com.rich.music.utils.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootTest
class MusicApplicationTests {

    // 将用户名和创建时间放入JWT的荷载头中
    public static final String CLAIM_KEY_USERNAME = "sub";
    public static final String CLAIM_KEY_CREATED = "created";

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;



//    @Test
//    public void testGenerateToken(UserDetails userDetails) {
//        String claims = jwtTokenUtil.generateToken(userDetails);
//        System.out.println(claims);
//    }

}
