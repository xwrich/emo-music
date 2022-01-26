package com.rich.music.controller;

import com.rich.music.pojo.Admin;
import com.rich.music.pojo.AdminLoginParam;
import com.rich.music.pojo.ResBean;
import com.rich.music.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @Author: Dock
 * @CreateTime: 2022/1/26
 * @Description: 登录
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回Token")
    @PostMapping("/login")
    public ResBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),request);
    }

    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if (null == principal) {
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;

    }


    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public ResBean logout() {
        return ResBean.success("注销成功");
    }
}
