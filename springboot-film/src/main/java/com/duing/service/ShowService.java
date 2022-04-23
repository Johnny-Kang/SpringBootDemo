package com.duing.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.duing.domain.Show;
import com.duing.domain.vo.ShowInfoVo;
import com.duing.domain.vo.ShowVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowService extends IService<Show> {
    List<ShowVO> listShowByFilmId(QueryWrapper query);
    ShowInfoVo getShowById(QueryWrapper query);
    IPage<ShowInfoVo> listShows(IPage<ShowInfoVo> page,QueryWrapper query);
}
