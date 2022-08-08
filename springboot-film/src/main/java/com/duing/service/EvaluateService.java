package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Evaluate;
import com.duing.domain.vo.EvaluateVO;
import com.duing.domain.vo.FilmVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EvaluateService extends IService<Evaluate> {
    List<EvaluateVO> listEvaluate(QueryWrapper<EvaluateVO> query);
}
