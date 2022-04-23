package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Cinema;
import com.duing.domain.Room;
import com.duing.domain.vo.CinemaVO;
import com.duing.mapper.CinemaMapper;
import com.duing.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImp extends ServiceImpl<CinemaMapper, Cinema> implements CinemaService {
    @Autowired
    private CinemaMapper cinemaMapper;
    @Override
    public IPage<CinemaVO> listCinemas(IPage<CinemaVO> page, QueryWrapper<CinemaVO> query) {
        return cinemaMapper.listCinemas(page,query);
    }

    @Override
    public List<Cinema> listCinemaBySort(QueryWrapper<Cinema> query) {
        return cinemaMapper.listCinemaBySort(query);
    }

    @Override
    public List<Cinema> listCinemasByFilmId(QueryWrapper<Cinema> query) {
        return cinemaMapper.listCinemasByFilmId(query);
    }

    @Override
    public List<Room> selectRoomByCinemaId(QueryWrapper<Cinema> query) {
        return cinemaMapper.selectRoomByCinemaId(query);
    }
}
