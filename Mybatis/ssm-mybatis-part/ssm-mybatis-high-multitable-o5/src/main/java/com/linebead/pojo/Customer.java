package com.linebead.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author liushengtao
 * @description 用户
 * @date 2024年12月02日14:40
 */
@Data
public class Customer {
    private Integer customerId;
    private String customerName;
    List<Order> orders;
}
