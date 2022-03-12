package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.DataBean;
import com.duing.mapper.DataMapper;
import com.duing.service.DataService;
import org.springframework.stereotype.Service;



@Service
public class DataServiceImpl extends ServiceImpl<DataMapper,DataBean> implements DataService {

}
