package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.domain.Order;
import com.duing.domain.vo.OrderVO;
import com.duing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderInfo")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orderTicket")
    public void orderTicket(Order order){
        System.out.println(order.toString());
        orderService.save(order);
    }
    //通过showId找到该场次已卖出去的票
    @GetMapping("/getSoldSeat")
    public Map getSoldSeat(Integer showId){
        QueryWrapper query = new QueryWrapper();
        query.select("group_concat(seat) as soldSeat").eq("show_id",showId);
        return orderService.getMap(query);
    }
    //通过userId找到该用户的所有订单信息
    @GetMapping("/listOrdersByUserId")
    public List<OrderVO> listOrdersByUserId(Integer userId){
        QueryWrapper<Order> query = new QueryWrapper();
        query.eq("o.user_id",userId).orderByDesc("o.create_time");
        return orderService.listOrdersByUserId(query);
    }
}
