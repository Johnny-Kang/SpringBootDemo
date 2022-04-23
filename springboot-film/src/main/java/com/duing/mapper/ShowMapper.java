package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.Room;
import com.duing.domain.Show;
import com.duing.domain.vo.ShowInfoVo;
import com.duing.domain.vo.ShowVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowMapper extends BaseMapper<Show> {
    @Select("select s.*,r.room from t_show as s\n" +
            "left join t_room as r on r.id = s.room_id "
            + "${ew.customSqlSegment}")
    List<ShowVO> listShowByFilmId(@Param(Constants.WRAPPER) QueryWrapper query);

    @Select("select * from t_show as s \n" +
            "left join t_film as f on f.id = s.film_id\n" +
            "left join t_cinema as c on c.id = s.cinema_id\n" +
            "left join t_room as r on r.id = s.room_id "
            + "${ew.customSqlSegment}")
    ShowInfoVo getShowById(@Param(Constants.WRAPPER) QueryWrapper query);

    @Select("SELECT s.id,s.view_date,s.view_time,s.film_id,s.cinema_id,s.room_id,s.price,f.film,f.length,c.cinema,a.`name` as area,r.room from t_show s \n" +
            "LEFT JOIN t_film f ON f.id = s.film_id\n" +
            "LEFT JOIN t_cinema c ON c.id = s.cinema_id\n" +
            "LEFT JOIN t_room r ON r.id = s.room_id\n" +
            "LEFT JOIN area a ON a.`code` = c.area_id " + "${ew.customSqlSegment}")
    IPage<ShowInfoVo> listShows(IPage<ShowInfoVo> page, @Param(Constants.WRAPPER) QueryWrapper query);
}
