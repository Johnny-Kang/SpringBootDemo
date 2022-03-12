package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Graph;
import com.duing.mapper.GraphMapper;
import com.duing.service.GraphService;
import org.springframework.stereotype.Service;

@Service
public class GraphServiceImpl extends ServiceImpl<GraphMapper, Graph> implements GraphService {
}
