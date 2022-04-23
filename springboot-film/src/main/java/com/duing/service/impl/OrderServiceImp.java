package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Order;
import com.duing.domain.vo.OrderVO;
import com.duing.domain.vo.ShowInfoVo;
import com.duing.mapper.OrderMapper;
import com.duing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public IPage<OrderVO> listOrders(IPage<OrderVO> page, QueryWrapper query) {
        return orderMapper.listOrders(page,query);
    }

    @Override
    public List<OrderVO> listOrdersByUserId(QueryWrapper<Order> query) {
        return orderMapper.listOrdersByUserId(query);
    }
}
