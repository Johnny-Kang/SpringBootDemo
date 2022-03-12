package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Cinema;
import com.duing.domain.vo.CinemaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaService extends IService<Cinema> {
    IPage<CinemaVO> listCinemas(IPage<CinemaVO> page, QueryWrapper<CinemaVO> query);
    List<Cinema> listCinemaBySort(QueryWrapper<Cinema> query);
    List<Cinema> listCinemasByFilmId(QueryWrapper<Cinema> query);
}
