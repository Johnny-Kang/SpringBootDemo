package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.RoomType;
import com.duing.mapper.RoomTypeMapper;
import com.duing.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImp extends ServiceImpl<RoomTypeMapper, RoomType> implements RoomTypeService {
    @Autowired
    private RoomTypeMapper roomTypeMapper;
    @Override
    public List<RoomType> getRoomTypeByCity(QueryWrapper query) {
        return roomTypeMapper.getRoomTypeByCity(query);
    }
}
