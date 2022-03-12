package com.duing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.duing.domain.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandMapper extends BaseMapper<Brand> {
    @Select("SELECT distinct b.id,b.brand FROM t_cinema as ci \n" +
            "left join t_brand as b on b.id = ci.brand_id\n" +
            "left join area as a on a.code = ci.area_id\n" +
            "left join city as c on c.code = a.city_code "
            +"${ew.customSqlSegment}")
    List<Brand> getBrandsByCity(@Param(Constants.WRAPPER) QueryWrapper query);
}
