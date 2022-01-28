package com.rich.music.service;

import com.rich.music.pojo.ResBean;
import com.rich.music.pojo.Singer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
public interface ISingerService extends IService<Singer> {

    /**
     * 添加歌手
     * @param singer
     * @return
     */
    ResBean addSinger(Singer singer);
}
