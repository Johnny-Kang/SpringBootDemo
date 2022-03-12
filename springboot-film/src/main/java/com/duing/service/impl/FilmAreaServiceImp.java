package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.FilmArea;
import com.duing.mapper.FilmAreaMapper;
import com.duing.service.FilmAreaService;
import org.springframework.stereotype.Service;

@Service
public class FilmAreaServiceImp extends ServiceImpl<FilmAreaMapper,FilmArea> implements FilmAreaService {
}
