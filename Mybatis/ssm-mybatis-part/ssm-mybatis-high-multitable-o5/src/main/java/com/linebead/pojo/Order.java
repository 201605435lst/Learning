package com.linebead.pojo;

import lombok.Data;

/**
 * @author liushengtao
 * @description 订单
 * @date 2024年12月02日14:44
 */
@Data
public class Order {
    private Integer orderId;
    private String orderName;
    private Customer customer;// 体现的是对一的关系
}
