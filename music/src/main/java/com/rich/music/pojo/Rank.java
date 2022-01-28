package com.rich.music.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
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
@TableName("t_rank")
@ApiModel(value="Rank对象", description="")
public class Rank implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 排行榜id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 榜单名称
     */
    @ApiModelProperty(value = "rankName")
    private String rankName;

    /**
     * 歌曲id
     */
    @ApiModelProperty(value = "singId")
    private Integer songId;

    /**
     * 榜单简介
     */
    @ApiModelProperty(value = "intro")
    private String intro;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "updateTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime updateTime;

    /**
     * 外键关联字段
     * 表示在数据库的表字段中，没有children，不用再去查找
     */
    @ApiModelProperty(value = "children")
    @TableField(exist = false)
    private List<Rank> children;

    @ApiModelProperty(value = "歌曲列表")
    @TableField(exist = false)
    private List<Song> songs;

}
