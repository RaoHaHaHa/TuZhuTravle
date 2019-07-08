package com.qf.travel.mapper;

import com.qf.travel.dto.OrderDto;
import com.qf.travel.entity.Order;

import java.util.List;

public interface OrderMapper {

    // 通过用户id查询用户订单
    List<OrderDto> findUserOrder(Long userId);

    //通过订单id 删除用户订单
    int deleteOrder(int order_id);

    //插入一条订单
    int insertOneOrder(Order order);
}
