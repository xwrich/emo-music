package com.rich.music.controller;


import com.rich.music.pojo.Category;
import com.rich.music.pojo.ResBean;
import com.rich.music.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
@Api(tags = "CategoryController")
@RestController
@RequestMapping("/song/category/type")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
    
    @ApiOperation(value = "获取所有歌曲分类")
    @GetMapping("/")
    public List<Category> getAllCategory() {
        return categoryService.list();
    }

    @ApiOperation(value = "添加歌曲分类")
    @PostMapping("/")
    public ResBean addCategory(@RequestBody Category category){
        category.setCreateTime(LocalDateTime.now());
        if (categoryService.save(category)) {
            return ResBean.success("添加成功！");
        } else {
            return ResBean.error("添加失败！");
        }
    }

    @ApiOperation(value = "修改歌曲分类信息")
    @PutMapping("/")
    public ResBean updateCategory(@RequestBody Category category){
        if (categoryService.updateById(category)) {
            return ResBean.success("修改成功！");
        } else {
            return ResBean.error("修改失败！");
        }
    }

    @ApiOperation(value = "删除歌曲分类")
    @DeleteMapping("/{id}")
    public ResBean deleteCategory(@PathVariable Integer id) {
        if (categoryService.removeById(id)) {
            return ResBean.success("删除成功！");
        } else {
            return ResBean.error("删除失败！");
        }
    }

    @ApiOperation(value = "批量删除歌曲分类")
    @DeleteMapping("/")
    public ResBean deleteCategoryByIds(Integer[] ids) {
        if (categoryService.removeByIds(Arrays.asList(ids))) {
            return ResBean.success("批量删除成功！");
        } else {
            return ResBean.error("批量删除失败！");
        }
    }
}
