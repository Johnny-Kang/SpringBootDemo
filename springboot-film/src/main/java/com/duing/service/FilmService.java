package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Film;
import com.duing.domain.vo.FilmVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmService extends IService<Film> {
    IPage<FilmVO> listFilms(IPage<FilmVO> page, QueryWrapper<FilmVO> query);
    List<FilmVO> listFilmsAndSort(QueryWrapper<FilmVO> query);
    List<FilmVO> listFilmsByCinemaId(QueryWrapper query);
}
