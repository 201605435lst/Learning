package com.linebead.mapper;

import com.linebead.pojo.Order;

public interface OrderMapper {

    /*获取订单的用户*/
    Order queryOrderById(Integer id);
}
