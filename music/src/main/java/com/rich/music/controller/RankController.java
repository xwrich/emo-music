package com.rich.music.controller;


import com.rich.music.pojo.*;
import com.rich.music.service.IRankService;
import com.rich.music.service.ISongService;
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
@Api(tags = "RankController")
@RestController
@RequestMapping("/song/rank/rankList")
public class RankController {

    @Autowired
    private IRankService rankService;
    @Autowired
    private ISongService songService;

    @ApiOperation(value = "获取所有榜单(分页)")
    @GetMapping("/")
    public ResPageBean getAllRank(@RequestParam(defaultValue = "1") Integer currentPage,
                                  @RequestParam(defaultValue = "5") Integer size,
                                  Song song) {
        return rankService.getAllRankByPage(currentPage,size,song);
    }

    /**
     * 根据榜单的song_id获取所有的歌曲名称
     * @return
     */
    @ApiOperation(value = "根据id获取所有歌曲名称")
    @GetMapping("/rankWithSongs")
    public List<Song> getAllRankWithSongs() {
        return rankService.getAllRankWithSongs();
    }

    @ApiOperation(value = "添加榜单")
    @PostMapping("/")
    public ResBean addRank(@RequestBody Rank rank) {
        return rankService.addRank(rank);
    }
}
