package com.rich.music.service.impl;

import com.rich.music.pojo.ResBean;
import com.rich.music.pojo.Singer;
import com.rich.music.mapper.SingerMapper;
import com.rich.music.service.ISingerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements ISingerService {

    @Autowired
    private SingerMapper singerMapper;

    /**
     * 添加歌手
     * @param singer
     * @return
     */
    @Override
    public ResBean addSinger(Singer singer) {
        return singerMapper.addSinger(singer);
    }
}
