package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Province;
import com.duing.mapper.ProvinceMapper;
import com.duing.service.ProvinceService;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImp extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
}
