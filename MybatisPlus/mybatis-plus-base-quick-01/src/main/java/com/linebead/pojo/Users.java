package com.linebead.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日20:13
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
