package com.rich.music.service.impl;

import com.rich.music.pojo.Song;
import com.rich.music.mapper.SongMapper;
import com.rich.music.service.ISongService;
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
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements ISongService {



}
