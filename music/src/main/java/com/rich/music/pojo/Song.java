package com.rich.music.pojo;

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
    private String author;

    /**
     * 歌曲名
     */
    private String songName;

    /**
     * 歌曲分类
     */
    private Integer categoryId;

    /**
     * 歌词
     */
    private String songWords;

    /**
     * 歌曲mp3/avi的url
     */
    private String audioUrl;

    /**
     * 歌曲MV的url
     */
    private String videoUrl;

    /**
     * 海报
     */
    private String post;

    /**
     * 简介
     */
    private String intro;


}
