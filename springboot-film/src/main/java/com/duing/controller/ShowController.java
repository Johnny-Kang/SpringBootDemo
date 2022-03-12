package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.domain.Show;
import com.duing.domain.vo.ShowInfoVo;
import com.duing.domain.vo.ShowVO;
import com.duing.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showInfo")
public class ShowController {
    @Autowired
    private ShowService showService;
    //通过影院id和电影id获得该电影的放映日期
    @GetMapping("/getShowDate")
    public List<Show> getShowDate(Integer cinemaId,Integer filmId){
        QueryWrapper<Show> query = new QueryWrapper<>();
        query.select("view_date").eq("cinema_id",cinemaId).eq("film_id",filmId).groupBy("view_date");
        return showService.list(query);
    }
    //通过影院id和电影id获得该电影的放映信息
    @GetMapping("/listShowByFilmId")
    public List<ShowVO> listShowByFilmId(Integer cinemaId,Integer filmId,String date){
        QueryWrapper<Show> query = new QueryWrapper<>();
        query.eq("cinema_id",cinemaId).eq("film_id",filmId).eq("s.view_date",date);
        return showService.listShowByFilmId(query);
    }
    //通过放映id获得电影,影院,影厅,放映信息
    @GetMapping("/getShowById")
    public ShowInfoVo getShowById(Integer id){
        QueryWrapper<ShowInfoVo> query = new QueryWrapper();
        query.eq("s.id",id);
        return showService.getShowById(query);
    }
}
