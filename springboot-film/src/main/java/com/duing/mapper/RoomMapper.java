package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.Room;
import com.duing.domain.vo.RoomVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper extends BaseMapper<Room> {
    @Select("SELECT r.id,r.room,row_num,r.column_num,r.room_type_id,rt.type AS room_type FROM t_room r\n" +
            "LEFT JOIN t_room_type rt ON rt.id = r.id " + "${ew.customSqlSegment}")
    IPage<RoomVO> listRooms(IPage<RoomVO> page, @Param(Constants.WRAPPER) QueryWrapper query);
}
