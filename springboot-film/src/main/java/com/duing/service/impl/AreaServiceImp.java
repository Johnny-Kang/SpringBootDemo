package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Area;
import com.duing.domain.dto.AreaDTO;
import com.duing.mapper.AreaMapper;
import com.duing.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImp extends ServiceImpl<AreaMapper,Area> implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public IPage<AreaDTO> getAreas(IPage<AreaDTO> page) {
        return areaMapper.getAreas(page);
    }

    @Override
    public IPage<AreaDTO> getAreaById(IPage<AreaDTO> page, QueryWrapper<AreaDTO> query) {
        return areaMapper.getAreaById(page,query);
    }

    @Override
    public List<Area> getAreasByCity(QueryWrapper query) {
        return areaMapper.getAreasByCity(query);
    }
}
