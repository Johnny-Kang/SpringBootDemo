package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Brand;


import java.util.List;

public interface BrandService extends IService<Brand> {
    List<Brand> getBrandsByCity(QueryWrapper query);
}
