package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.RoomType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeMapper extends BaseMapper<RoomType> {
    @Select("SELECT distinct rt.* FROM t_cinema as ci \n" +
            "left join t_brand as b on b.id = ci.brand_id\n" +
            "left join area as a on a.code = ci.area_id\n" +
            "left join city as c on c.code = a.city_code \n" +
            "left join t_room as r on find_in_set(r.id,ci.room_id)\n" +
            "left join t_room_type as rt on rt.id = r.room_type_id\n"
            + "${ew.customSqlSegment}")
    List<RoomType> getRoomTypeByCity(@Param(Constants.WRAPPER) QueryWrapper query);
}
