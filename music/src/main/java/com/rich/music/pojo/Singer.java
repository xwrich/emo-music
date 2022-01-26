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
@TableName("t_singer")
@ApiModel(value="Singer对象", description="")
public class Singer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 歌手id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 海报
     */
    private String post;

    /**
     * 出生年月
     */
    private LocalDateTime birth;

    /**
     * 籍贯
     */
    private String location;

    /**
     * 介绍
     */
    private String intro;


}
