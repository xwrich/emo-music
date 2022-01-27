package com.rich.music.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Dock
 * @CreateTime: 2022/1/26
 * @Description: 测试
 */
@Api(tags = "HelloController")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello,SpringBoot";
    }

    @GetMapping("/comment/basic/test")
    public String comment() {
        return "comment/basic/test";
    }
}
