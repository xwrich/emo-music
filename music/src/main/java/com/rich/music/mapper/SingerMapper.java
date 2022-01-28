package com.rich.music.mapper;

import com.rich.music.pojo.ResBean;
import com.rich.music.pojo.Singer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
public interface SingerMapper extends BaseMapper<Singer> {

    /**
     * 添加歌手
     * @param singer
     * @return
     */
    ResBean addSinger(Singer singer);
}
