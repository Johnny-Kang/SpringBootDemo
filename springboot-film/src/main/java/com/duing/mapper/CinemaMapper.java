package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.Cinema;
import com.duing.domain.Room;
import com.duing.domain.vo.CinemaVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CinemaMapper extends BaseMapper<Cinema> {
    @Select("select c.id,c.cinema,c.address,c.is_rebook,c.is_refund,c.create_time,b.brand,a.name as area,ci.name as city from t_cinema as c \n" +
            "left join t_brand as b on b.id = c.brand_id \n" +
            "left join area as a on a.code = c.area_id \n" +
            "left join city as ci on ci.code = a.city_code "
            +"${ew.customSqlSegment}")
    IPage<CinemaVO> listCinemas(IPage<CinemaVO> page,@Param(Constants.WRAPPER) QueryWrapper<CinemaVO> query);

    @Select("SELECT  ci.id,ci.address,ci.area_id,ci.brand_id,ci.cinema,ci.create_time,ci.is_rebook as rebook,ci.is_refund as refund " +
            "FROM t_cinema as ci \n" +
            "left join t_brand as b on b.id = ci.brand_id\n" +
            "left join area as a on a.code = ci.area_id\n" +
            "left join city as c on c.code = a.city_code \n" +
            "left join t_room as r on find_in_set(r.id,ci.room_id)\n" +
            "left join t_room_type as rt on rt.id = r.room_type_id "
            +"${ew.customSqlSegment}")
    List<Cinema> listCinemaBySort(@Param(Constants.WRAPPER) QueryWrapper<Cinema> query);

    @Select("SELECT ci.id,ci.address,ci.area_id,ci.brand_id,ci.cinema,\n" +
            "ci.create_time,ci.is_rebook as rebook,ci.is_refund as refund FROM t_cinema as ci \n" +
            "left join t_show as s on s.cinema_id = ci.id\n" +
            "left join t_brand as b on b.id = ci.brand_id \n" +
            "left join area as a on a.code = ci.area_id \n" +
            "left join city as c on c.code = a.city_code \n" +
            "left join t_room as r on find_in_set(r.id,ci.room_id) \n" +
            "left join t_room_type as rt on rt.id = r.room_type_id "
            +"${ew.customSqlSegment}")
    List<Cinema> listCinemasByFilmId(@Param(Constants.WRAPPER) QueryWrapper<Cinema> query);

    @Select("SELECT r.id,r.room FROM t_cinema c\n" +
            "LEFT JOIN t_room r ON FIND_IN_SET(r.id,c.room_id)\n"
            +"${ew.customSqlSegment}")
    List<Room> selectRoomByCinemaId(@Param(Constants.WRAPPER) QueryWrapper<Cinema> query);
}
