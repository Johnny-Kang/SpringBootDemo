package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.FilmType;
import com.duing.mapper.FilmTypeMapper;
import com.duing.service.FilmTypeService;
import org.springframework.stereotype.Service;

@Service
public class FilmTypeServiceImp extends ServiceImpl<FilmTypeMapper, FilmType> implements FilmTypeService {
}
