package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.Film;
import com.duing.domain.vo.FilmVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Repository
public interface FilmMapper extends BaseMapper<Film> {
    @Select("select f.id,f.film,f.english_name,f.director,f.Player,f.length,\n" +
            "f.synopsis,f.status,f.play_Time,f.img_path as img,f.wish,f.score,a.area,y.year,\n" +
            "group_concat(t.type) as type from t_film as f \n" +
            "left join t_film_area as a on f.area_id = a.id \n" +
            "left join t_film_year as y on f.year_id = y.id \n" +
            "left join t_film_type as t on find_in_set(t.id,f.type_id) "
            +"${ew.customSqlSegment}" + "group by f.id")
    IPage<FilmVO> listFilms(IPage<FilmVO> page, @Param(Constants.WRAPPER) QueryWrapper<FilmVO> query);


    @Select("select f.id,f.film,f.english_name,f.director,f.Player,f.length,\n" +
            "f.synopsis,f.status,f.play_Time,f.img_path as img,f.wish,f.score,a.area,y.year,\n" +
            "group_concat(t.type) as type from t_film as f \n" +
            "left join t_film_area as a on f.area_id = a.id \n" +
            "left join t_film_year as y on f.year_id = y.id \n" +
            "left join t_film_type as t on find_in_set(t.id,f.type_id) "
            +"${ew.customSqlSegment}")
    List<FilmVO> listFilmsAndSort(@Param(Constants.WRAPPER) QueryWrapper<FilmVO> query);

    @Select("select f.id,f.film,f.Player,f.length,f.img_path as img,f.wish,f.score\n" +
            ",group_concat(distinct t.type) as type from t_film as f\n" +
            "left join t_film_type as t on find_in_set(t.id,f.type_id)\n" +
            "left join t_show as s on s.film_id = f.id  \n"
            +"${ew.customSqlSegment}" + "group by f.id")
    List<FilmVO> listFilmsByCinemaId(@Param(Constants.WRAPPER) QueryWrapper query);
}
