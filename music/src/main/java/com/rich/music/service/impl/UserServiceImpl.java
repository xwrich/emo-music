package com.rich.music.service.impl;

import com.rich.music.pojo.User;
import com.rich.music.mapper.UserMapper;
import com.rich.music.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
