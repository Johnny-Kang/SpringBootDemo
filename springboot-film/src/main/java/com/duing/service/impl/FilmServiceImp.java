package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Film;
import com.duing.domain.vo.FilmVO;
import com.duing.mapper.FilmMapper;
import com.duing.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImp extends ServiceImpl<FilmMapper, Film> implements FilmService {
    @Autowired
    private FilmMapper filmMapper;
    @Override
    public IPage<FilmVO> listFilms(IPage<FilmVO> page, QueryWrapper<FilmVO> query) {
        return filmMapper.listFilms(page,query);
    }

    @Override
    public List<FilmVO> listFilmsAndSort(QueryWrapper<FilmVO> query) {
        return filmMapper.listFilmsAndSort(query);
    }

    @Override
    public List<FilmVO> listFilmsByCinemaId(QueryWrapper query) {
        return filmMapper.listFilmsByCinemaId(query);
    }
}
