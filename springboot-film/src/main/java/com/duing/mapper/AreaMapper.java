package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.Area;
import com.duing.domain.dto.AreaDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaMapper extends BaseMapper<Area> {
    @Select("select a.code,a.name as area,c.name as city,p.name as province from area as a " +
            "left join city as c on c.code = a.city_code " +
            "left join province as p on a.province_code = p.code "
            +"${ew.customSqlSegment}")
    IPage<AreaDTO> getAreaById(IPage<AreaDTO> page, @Param(Constants.WRAPPER) QueryWrapper<AreaDTO> query);

    @Select("select a.code,a.name as area,c.name as city,p.name as province from area as a " +
            "left join city as c on c.code = a.city_code " +
            "left join province as p on a.province_code = p.code")
    IPage<AreaDTO> getAreas(IPage<AreaDTO> page);

    @Select("SELECT distinct a.* FROM t_cinema as ci \n" +
            "left join area as a on a.code = ci.area_id\n" +
            "left join city as c on c.code = a.city_code \n"
            +"${ew.customSqlSegment}")
    List<Area> getAreasByCity(@Param(Constants.WRAPPER) QueryWrapper query);
}
