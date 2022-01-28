package com.rich.music.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_song")
@ApiModel(value="Song对象", description="")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 歌曲id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 作者
     */
    @ApiModelProperty(value = "singerId")
    private String singerId;

    /**
     * 歌曲分类
     */
    @ApiModelProperty(value = "categoryId")
    private Integer categoryId;

    /**
     * 歌曲名
     */
    @ApiModelProperty(value = "songName")
    private String songName;

    /**
     * 歌词
     */
    @ApiModelProperty(value = "songWords")
    private String songWords;

    /**
     * 歌曲mp3/avi的url
     */
    @ApiModelProperty(value = "audioUrl")
    private String audioUrl;

    /**
     * 歌曲MV的url
     */
    @ApiModelProperty(value = "videoUrl")
    private String videoUrl;

    /**
     * 海报
     */
    @ApiModelProperty(value = "post")
    private String post;

    /**
     * 简介
     */
    @ApiModelProperty(value = "intro")
    private String intro;

    @ApiModelProperty(value = "singerName")
    @TableField(exist = false)
    private String singerName;

    @ApiModelProperty(value = "categoryName")
    @TableField(exist = false)
    private String categoryName;


}
