package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Room;
import com.duing.domain.RoomType;
import com.duing.domain.vo.FilmVO;

import java.util.List;

public interface RoomService extends IService<Room> {
    IPage<Room> listRooms(IPage<Room> page, QueryWrapper query);
}
