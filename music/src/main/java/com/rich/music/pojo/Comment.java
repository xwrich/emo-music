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
@TableName("t_comment")
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 评论用户id
     */
    private Integer user_id;

    /**
     * 评论歌曲id
     */
    private Integer song_id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;


}
