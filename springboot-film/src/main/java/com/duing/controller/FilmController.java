package com.duing.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duing.domain.Film;
import com.duing.domain.FilmArea;
import com.duing.domain.FilmType;
import com.duing.domain.FilmYear;
import com.duing.domain.vo.FilmVO;
import com.duing.service.FilmService;
import com.duing.service.impl.FilmAreaServiceImp;
import com.duing.service.impl.FilmServiceImp;
import com.duing.service.impl.FilmTypeServiceImp;
import com.duing.service.impl.FilmYearServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/filmInfo")
public class FilmController {
    @Autowired
    private FilmServiceImp filmService;
    @Autowired
    private FilmTypeServiceImp filmTypeService;
    @Autowired
    private FilmYearServiceImp filmYearService;
    @Autowired
    private FilmAreaServiceImp filmAreaService;

    //电影
    @GetMapping("/listFilms")
    public IPage<FilmVO> listFilms(FilmVO filmVO){
        IPage<FilmVO> page = new Page<>(filmVO.getCurrentPage(),filmVO.getPageSize());
        QueryWrapper<FilmVO> query = new QueryWrapper<>();
        query.like(filmVO.getFilm()!="","f.film",filmVO.getFilm())
                .like(filmVO.getEnglishName()!="","f.english_name",filmVO.getEnglishName())
                .eq(filmVO.getArea()!="","f.area_id",filmVO.getArea())
                .eq(filmVO.getYear()!="","f.year_id",filmVO.getYear())
                .like(filmVO.getPlayTime()!="","f.play_time",filmVO.getPlayTime())
                .eq("f.is_deleted",0);
        return filmService.listFilms(page,query);
    }
    @GetMapping("listFilmsAndSort")
    public List<FilmVO> listFilmsAndSort(FilmVO filmVO){
        String sort = "";
        if ("1".equals(filmVO.getSort())){
            sort = "f.play_Time";
        }else if ("2".equals(filmVO.getSort())){
            sort = "f.score";
        }else {
            sort = "f.wish";
        }
        QueryWrapper<FilmVO> query = new QueryWrapper<>();
        query.eq("f.is_deleted","0")
                .eq(StringUtils.isNotBlank(filmVO.getStatus().toString()),"f.status",filmVO.getStatus())
                .eq(StringUtils.isNotBlank(filmVO.getType()),"t.type",filmVO.getType())
                .eq(StringUtils.isNotBlank(filmVO.getArea()),"a.area",filmVO.getArea())
                .eq(StringUtils.isNotBlank(filmVO.getYear()),"y.year",filmVO.getYear())
                .groupBy("f.id").orderByDesc(sort);
        return filmService.listFilmsAndSort(query);
    }
    //正在热映的电影
    @GetMapping("/listFilmsByStatus")
    public List<Film> listFilmsByStatus(Integer status){
        QueryWrapper<Film> query = new QueryWrapper<Film>();
        query.eq("is_deleted",0).eq("status",status);
        return filmService.list(query);
    }
    //通过filmId找到对应的电影信息
    @GetMapping("/getFilmById")
    public Film getFilmById(Integer id){
        return filmService.getById(id);
    }

    //类别
    @GetMapping("/getTypes")
    public List<FilmType> getTypes(){
        return filmTypeService.list();
    }

    @GetMapping("/listTypes")
    public IPage<FilmType> listTypes(Integer currentPage,Integer pageSize,String type){
        IPage<FilmType> page = new Page<FilmType>(currentPage,pageSize);
        QueryWrapper<FilmType> queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_deleted",0).like(type!="","type",type);
        return filmTypeService.page(page,queryWrapper);
    }

    //年代
    @GetMapping("/getYears")
    public List<FilmYear> getYears(){
        return filmYearService.list();
    }

    @GetMapping("/listYears")
    public IPage<FilmYear> listYears(Integer currentPage,Integer pageSize,String year){
        IPage<FilmYear> page = new Page<FilmYear>(currentPage,pageSize);
        QueryWrapper<FilmYear> queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_deleted",0).eq(year!="","id",year==""?"":Integer.parseInt(year));
        return filmYearService.page(page,queryWrapper);
    }
    //地区
    @GetMapping("/getAreas")
    public List<FilmArea> getAreas(){
        return  filmAreaService.list();
    }

    @GetMapping("/listAreas")
    public IPage<FilmArea> listAreas(Integer currentPage, Integer pageSize, String area){
        IPage<FilmArea> page = new Page<>(currentPage,pageSize);
        QueryWrapper<FilmArea> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted",0).eq(area!="","id",area==""?"":Integer.parseInt(area));
        return filmAreaService.page(page,queryWrapper);
    }
    //通过cinemaId得到该影院所有的放映电影列表
    @GetMapping("/listFilmsByCinemaId")
    public List<FilmVO> listFilmsByCinemaId(Integer id){
        QueryWrapper query = new QueryWrapper();
        query.eq("s.cinema_id",id);
        return filmService.listFilmsByCinemaId(query);
    }
}
