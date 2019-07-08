package com.qf.travel.service;

import com.qf.travel.dto.OrderDto;
import com.qf.travel.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    //通过用户ID查询用户订单
    List<OrderDto> findUserOrder(Long userId);

    //通过订单id 删除用户订单
    int deleteOrder(int order_id);

    //生成订单
    int insertOneOrder(Order order);
}
