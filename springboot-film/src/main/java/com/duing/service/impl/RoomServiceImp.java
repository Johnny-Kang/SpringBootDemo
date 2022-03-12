package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Room;
import com.duing.mapper.RoomMapper;
import com.duing.service.RoomService;
import org.springframework.stereotype.Repository;

@Repository
public class RoomServiceImp extends ServiceImpl<RoomMapper, Room> implements RoomService {
}
