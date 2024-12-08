package com.linebead.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName student
 */
@Data
public class Student implements Serializable {
    private Integer stuId;

    private String stuName;

    private static final long serialVersionUID = 1L;
}