package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Room;
import com.duing.domain.RoomType;
import com.duing.domain.vo.FilmVO;
import com.duing.domain.vo.RoomVO;

import java.util.List;

public interface RoomService extends IService<Room> {
    IPage<RoomVO> listRooms(IPage<RoomVO> page, QueryWrapper query);
}
