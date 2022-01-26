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
    private String rank_name;

    /**
     * 歌曲id
     */
    private Integer song_id;

    /**
     * 榜单简介
     */
    private String intro;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;


}
