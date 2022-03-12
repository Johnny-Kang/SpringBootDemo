package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.FilmYear;
import com.duing.mapper.FilmYearMapper;
import com.duing.service.FilmYearService;
import org.springframework.stereotype.Service;

@Service
public class FilmYearServiceImp extends ServiceImpl<FilmYearMapper, FilmYear> implements FilmYearService {
}
