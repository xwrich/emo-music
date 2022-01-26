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
     * 歌曲名
     */
    private String song_name;

    /**
     * 歌曲分类
     */
    private Integer category_id;

    /**
     * 歌词
     */
    private String song_words;

    /**
     * 歌曲mp3/avi的url
     */
    private String audio_url;

    /**
     * 歌曲MV的url
     */
    private String video_url;

    /**
     * 海报
     */
    private String post;

    /**
     * 简介
     */
    private String intro;


}
