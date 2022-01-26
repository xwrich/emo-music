package com.rich.music.service.impl;

import com.rich.music.pojo.Album;
import com.rich.music.mapper.AlbumMapper;
import com.rich.music.service.IAlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements IAlbumService {

}
