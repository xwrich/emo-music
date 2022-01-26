package com.rich.music.service.impl;

import com.rich.music.pojo.Comment;
import com.rich.music.mapper.CommentMapper;
import com.rich.music.service.ICommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
