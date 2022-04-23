package com.duing.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duing.domain.*;
import com.duing.domain.vo.FilmVO;
import com.duing.service.FilmService;
import com.duing.service.impl.FilmAreaServiceImp;
import com.duing.service.impl.FilmServiceImp;
import com.duing.service.impl.FilmTypeServiceImp;
import com.duing.service.impl.FilmYearServiceImp;

import com.duing.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
    //通过id删除电影类别信息
    @PostMapping("/deleteFilmTypeById")
    public void deleteFilmTypeById(@RequestBody HashMap<String,Object> data) {
        filmTypeService.removeById((Integer)data.get("id"));
    }
    //新增电影类别
    @PostMapping("/addFilmType")
    public void addFilmType(@RequestBody FilmType filmType){
        filmTypeService.save(filmType);
    }
    //通过id删除电影区域
    @PostMapping("/deleteFilmAreaById")
    public void deleteFilmAreaById(@RequestBody HashMap<String,Object> data) {
        filmAreaService.removeById((Integer)data.get("id"));
    }
    //新增电影区域
    @PostMapping("/addFilmArea")
    public void addFilmArea(@RequestBody FilmArea filmArea){
        filmAreaService.save(filmArea);
    }
    //通过id删除电影年代
    @PostMapping("/deleteFilmYearById")
    public void deleteFilmYearById(@RequestBody HashMap<String,Object> data) {
        filmYearService.removeById((Integer)data.get("id"));
    }
    //新增电影年代
    @PostMapping("/addFilmYear")
    public void addFilmYear(@RequestBody FilmYear filmYear){
        filmYearService.save(filmYear);
    }

    //通过id删除电影年代
    @PostMapping("/deleteFilmById")
    public void deleteFilmById(@RequestBody HashMap<String,Object> data) {
        filmService.removeById((Integer)data.get("id"));
    }
    //新增电影年代
    @PostMapping("/addFilm")
    public void addFilm(@RequestParam("imageFiles") MultipartFile[] imageFiles,Film film){
        //获取前端上传得文件称
        String fileName = imageFiles[0].getOriginalFilename();
        //取文件名下标 给文件重命名
        String suffix = fileName.substring(fileName.indexOf("."));
        //取一个随机id给文件重命名
        String uuid = MyUtil.get16UUID();
        String newName = uuid+fileName+suffix;
        //E:/java/img/yyyy/MM/dd
        String fileDirPath = "D://Vue/vueProjects//img";
        File dirFile = new File(fileDirPath);
        if(!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File newFile = new File(fileDirPath+"//"+newName);
        try {
            imageFiles[0].transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        film.setImgPath(newName);
        filmService.save(film);
    }
}
