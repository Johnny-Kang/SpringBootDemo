package com.duing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Show;
import com.duing.domain.vo.ShowInfoVo;
import com.duing.domain.vo.ShowVO;
import com.duing.mapper.ShowMapper;
import com.duing.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImp extends ServiceImpl<ShowMapper, Show> implements ShowService {
    @Autowired
    private ShowMapper showMapper;

    @Override
    public List<ShowVO> listShowByFilmId(QueryWrapper query) {
        return showMapper.listShowByFilmId(query);
    }

    @Override
    public ShowInfoVo getShowById(QueryWrapper query) {
        return showMapper.getShowById(query);
    }
}
