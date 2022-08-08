package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.Evaluate;
import com.duing.domain.vo.EvaluateVO;
import com.duing.domain.vo.FilmVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateMapper extends BaseMapper<Evaluate> {

    @Select("SELECT e.*,u.img_url img,u.username FROM t_evaluate e \n" +
            "LEFT JOIN t_user u ON u.id  = e.user_id "
            +"${ew.customSqlSegment}")
    List<EvaluateVO> listEvaluate(@Param(Constants.WRAPPER) QueryWrapper<EvaluateVO> query);
}
