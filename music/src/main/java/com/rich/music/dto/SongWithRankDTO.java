package com.rich.music.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Dock
 * @CreateTime: 2022/1/28
 * @Description: Rank表后端实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongWithRankDTO {
    @ApiModelProperty(value = "歌曲id")
    private Integer songId;
    @ApiModelProperty(value = "歌曲名称")
    private String songName;

}
