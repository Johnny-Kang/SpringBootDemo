package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Evaluate;
import com.duing.domain.vo.EvaluateVO;
import com.duing.mapper.EvaluateMapper;
import com.duing.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImp extends ServiceImpl<EvaluateMapper, Evaluate> implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public List<EvaluateVO> listEvaluate(QueryWrapper<EvaluateVO> query) {
        return evaluateMapper.listEvaluate(query);
    }
}
