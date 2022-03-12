package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Order;
import com.duing.domain.vo.OrderVO;

import java.util.List;

public interface OrderService extends IService<Order> {
    List<OrderVO> listOrdersByUserId(QueryWrapper<Order> query);
}
