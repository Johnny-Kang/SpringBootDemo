package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Area;
import com.duing.domain.dto.AreaDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaService extends IService<Area> {
    IPage<AreaDTO> getAreas(IPage<AreaDTO> page);
    IPage<AreaDTO> getAreaById(IPage<AreaDTO> page, QueryWrapper<AreaDTO> query);
    List<Area> getAreasByCity(QueryWrapper query);
}
