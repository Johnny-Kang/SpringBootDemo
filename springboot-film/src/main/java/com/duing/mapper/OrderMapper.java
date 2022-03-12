package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.Order;
import com.duing.domain.RoomType;
import com.duing.domain.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select o.id,o.order_number,o.count,o.price,o.seat,o.create_time,f.film,f.img_path as img," +
            "c.cinema,c.address,r.room,s.view_date,s.view_time from t_order as o \n" +
            "left join t_show as s on s.id = o.show_id \n" +
            "left join t_film as f on f.id = s.film_id\n" +
            "left join t_cinema as c on c.id = s.cinema_id\n" +
            "left join t_room as r on r.id = s.room_id "
            + "${ew.customSqlSegment}")
    List<OrderVO> listOrdersByUserId(@Param(Constants.WRAPPER) QueryWrapper<Order> query);
}
