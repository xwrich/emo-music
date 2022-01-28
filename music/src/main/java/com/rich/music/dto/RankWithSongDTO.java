package com.rich.music.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Dock
 * @CreateTime: 2022/1/28
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankWithSongDTO {

    @ApiModelProperty(value = "排行榜id")
    private Integer id;

    @ApiModelProperty(value = "排行榜名称")
    private String rankName;


    private List<RankWithSongDTO> songDTOList;
}
