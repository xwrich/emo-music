package com.rich.music.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rich.music.pojo.*;
import com.rich.music.mapper.RankMapper;
import com.rich.music.service.IRankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
@Service
public class RankServiceImpl extends ServiceImpl<RankMapper, Rank> implements IRankService {

    @Autowired
    private RankMapper rankMapper;


    @Override
    public ResPageBean getAllRankByPage(Integer currentPage, Integer size, Song song) {
        // 开启分页
        Page<Rank> page = new Page<>(currentPage,size);
        IPage<Song> rankByPage = rankMapper.getAllRankByPage(page, song);
        ResPageBean resPageBean = new ResPageBean(rankByPage.getTotal(), rankByPage.getRecords());
        return resPageBean;
    }

    /**
     * 根据榜单的song_id获取所有的歌曲名称
     * @return
     */
    @Override
    public List<Song> getAllRankWithSongs() {
        return rankMapper.getAllRankWithSongs();
    }



    @Override
    public ResBean addRank(Rank rank) {
        return rankMapper.addRank(rank);
    }
}
