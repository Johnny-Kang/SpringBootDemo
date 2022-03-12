package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.RoomType;

import java.util.List;

public interface RoomTypeService extends IService<RoomType> {
    List<RoomType> getRoomTypeByCity(QueryWrapper query);
}
