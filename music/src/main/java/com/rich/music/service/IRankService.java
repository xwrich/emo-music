package com.rich.music.service;

import com.rich.music.pojo.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
public interface IRankService extends IService<Rank> {

    /**
     * 获取所有榜单(分页)
     * @param currentPage
     * @param size
     * @return
     */
    ResPageBean getAllRankByPage(Integer currentPage, Integer size, Song song);

    /**
     * 根据榜单的song_id获取所有的歌曲名称
     * @return
     */
    List<Song> getAllRankWithSongs();

    ResBean addRank(Rank rank);


}
