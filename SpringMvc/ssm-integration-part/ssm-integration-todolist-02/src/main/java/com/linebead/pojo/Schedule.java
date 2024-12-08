package com.linebead.pojo;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * projectName: com.atguigu.pojo
 *
 * description: 任务实体类
 */
@Data
public class Schedule {

    private Integer id;
    @NotBlank
    private String title;

    private Boolean completed;
}