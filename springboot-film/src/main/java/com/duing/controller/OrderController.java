package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duing.domain.Order;
import com.duing.domain.vo.OrderVO;
import com.duing.domain.vo.ShowInfoVo;
import com.duing.service.OrderService;
import com.duing.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderInfo")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orderTicket")
    public void orderTicket(Order order){
        order.setOrderNumber(MyUtil.get16UUID());
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

    @GetMapping("/listOrders")
    public IPage<OrderVO> listOrders(OrderVO orderVO){
        IPage<OrderVO> page = new Page<>(orderVO.getCurrentPage(),orderVO.getPageSize());
        QueryWrapper<OrderVO> query = new QueryWrapper<>();
        query.eq(StringUtils.isNotBlank(orderVO.getOrderNumber()),"o.order_number",orderVO.getOrderNumber())
                .like(StringUtils.isNotBlank(orderVO.getFilm()),"f.film",orderVO.getFilm())
                .like(StringUtils.isNotBlank(orderVO.getCinema()),"c.cinema",orderVO.getCinema())
                .eq(StringUtils.isNotBlank(orderVO.getUsername()),"u.username",orderVO.getUsername())
                .eq(StringUtils.isNotBlank(orderVO.getPhone()),"u.phone",orderVO.getPhone());
        return orderService.listOrders(page,query);
    }

    @PostMapping("/deleteOrderById")
    public void deleteOrderById(@RequestBody HashMap<String,Object> data) {
        orderService.removeById((Integer)data.get("id"));
    }
}
