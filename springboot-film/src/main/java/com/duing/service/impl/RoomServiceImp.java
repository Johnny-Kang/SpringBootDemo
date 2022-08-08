package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Room;
import com.duing.domain.RoomType;
import com.duing.domain.vo.FilmVO;
import com.duing.domain.vo.RoomVO;
import com.duing.mapper.RoomMapper;
import com.duing.mapper.RoomTypeMapper;
import com.duing.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomServiceImp extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Autowired
    private RoomMapper roomMapper;


    @Override
    public IPage<RoomVO> listRooms(IPage<RoomVO> page, QueryWrapper query) {
        return roomMapper.listRooms(page,query);
    }
}
