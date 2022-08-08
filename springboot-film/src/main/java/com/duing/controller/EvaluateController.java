package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.domain.Brand;
import com.duing.domain.Evaluate;
import com.duing.domain.vo.EvaluateVO;
import com.duing.service.EvaluateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evaluateInfo")
@RequiredArgsConstructor(onConstructor =@_(@Autowired))
public class EvaluateController {

    private final EvaluateService evaluateService;
    //新增评论
    @PostMapping("/addEvaluate")
    public void addBrand(@RequestBody Evaluate evaluate){
        evaluateService.save(evaluate);
    }

    @PostMapping("/listEvaluate")
    public List<EvaluateVO> listEvaluate(@RequestBody Evaluate evaluate){
        QueryWrapper<EvaluateVO> query = new QueryWrapper<>();
        query.eq("e.film_id",evaluate.getFilmId());
        return evaluateService.listEvaluate(query);
    }
}
