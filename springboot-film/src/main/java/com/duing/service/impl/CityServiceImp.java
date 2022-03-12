package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.City;
import com.duing.mapper.CityMapper;
import com.duing.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImp extends ServiceImpl<CityMapper, City> implements CityService {
}
