package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Brand;
import com.duing.mapper.BrandMapper;
import com.duing.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImp extends ServiceImpl<BrandMapper, Brand> implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> getBrandsByCity(QueryWrapper query) {
        return brandMapper.getBrandsByCity(query);
    }
}
