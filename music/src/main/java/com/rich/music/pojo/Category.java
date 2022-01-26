package com.rich.music.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Dock
 * @since 2022-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_category")
@ApiModel(value="Category对象", description="")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名
     */
    private String category_name;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;


}
