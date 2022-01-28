package com.rich.music.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rich.music.pojo.Rank;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rich.music.pojo.ResBean;
import com.rich.music.pojo.Singer;
import com.rich.music.pojo.Song;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
public interface RankMapper extends BaseMapper<Rank> {

    /**
     * 获取所有榜单（分页）
     * @param page
     * @param song
     * @return
     */
    IPage<Song> getAllRankByPage(Page<Rank> page, @Param("song") Song song);

    /**
     * 根据榜单的song_id获取所有的歌曲名称
     * @return
     */
    List<Song> getAllRankWithSongs();

    ResBean addRank(Rank rank);



}
