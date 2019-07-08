package com.qf.travel.service.Impl;

import com.qf.travel.dto.OrderDto;
import com.qf.travel.entity.Order;
import com.qf.travel.mapper.OrderMapper;
import com.qf.travel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    public List<OrderDto> findUserOrder(Long userId) {
        return orderMapper.findUserOrder(userId);
    }

    @Override
    public int deleteOrder(int order_id) {
        return 0;
    }

    @Override
    public int insertOneOrder(Order order) {
        return 0;
    }
}
