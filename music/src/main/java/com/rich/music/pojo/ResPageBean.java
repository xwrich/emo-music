package com.rich.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Dock
 * @CreateTime: 2022/1/27
 * @Description: 分页公共返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResPageBean {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据List
     */
    private List<?> data;
}
