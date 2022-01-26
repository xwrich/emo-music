package com.rich.music.service.impl;

import com.rich.music.pojo.Category;
import com.rich.music.mapper.CategoryMapper;
import com.rich.music.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
