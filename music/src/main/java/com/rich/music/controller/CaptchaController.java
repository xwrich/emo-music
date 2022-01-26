package com.rich.music.controller;

import com.rich.music.pojo.ResBean;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dock
 * @CreateTime: 2022/1/27
 * @Description: 验证码
 */
@Api(tags = "验证码模块")
@RestController
public class CaptchaController {

    @ApiOperation(value = "获取图形验证码")
    @GetMapping("/captcha")
    public ResBean captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //长，宽，位数
        GifCaptcha gifCaptcha = new GifCaptcha(100, 42, 5);
        //设置类型
        gifCaptcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);
        //生成验证码
        String code = gifCaptcha.text();
        //输出验证码
        System.out.println("验证码内容 captcha ===> " + code);
//		gifCaptcha.out(response.getOutputStream());
        //验证码放入Session中
        request.getSession().setAttribute("captcha", code);

        Map<String,String> map = new HashMap<>();
        map.put("code", gifCaptcha.toBase64());

        return ResBean.success("验证码生成成功！",map);
    }

}

