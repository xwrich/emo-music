package com.rich.music.controller;


import com.rich.music.pojo.ResBean;
import com.rich.music.pojo.Singer;
import com.rich.music.service.ISingerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
@Api(tags = "SingerController")
@RestController
@RequestMapping("/song/singer/list")
public class SingerController {

    @Autowired
    private ISingerService singerService;

    @ApiOperation(value = "获取所有歌手")
    @GetMapping("/")
    public List<Singer> getAllSinger() {
        return singerService.list();
    }

    @ApiOperation(value = "添加歌手")
    @PostMapping("/")
    public ResBean addSinger(@RequestBody Singer singer) {
        return singerService.addSinger(singer);
    }

}
