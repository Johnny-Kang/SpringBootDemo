package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duing.domain.*;
import com.duing.domain.dto.AreaDTO;
import com.duing.domain.vo.AreaVO;
import com.duing.domain.vo.CinemaVO;
import com.duing.domain.vo.CityVO;
import com.duing.domain.vo.ProvinceVO;
import com.duing.service.*;
import com.duing.service.impl.BrandServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cinemaInfo")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private BrandServiceImp brandService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AreaService areaService;

    @GetMapping("/listCinemas")
    public IPage<CinemaVO> listCinemas(CinemaVO cinemaVO){
        IPage<CinemaVO> page = new Page(cinemaVO.getCurrentPage(),cinemaVO.getPageSize());
        QueryWrapper<CinemaVO> query = new QueryWrapper();
        query.eq("c.is_deleted",0).eq(cinemaVO.getBrand()!="","b.id",cinemaVO.getBrand())
                .eq(cinemaVO.getArea()!=null,"a.code",cinemaVO.getArea())
                .eq(cinemaVO.getIsRebook()!=null,"c.is_rebook",cinemaVO.getIsRebook())
                .eq(cinemaVO.getIsRefund()!=null,"c.is_refund",cinemaVO.getIsRefund())
                .like(cinemaVO.getCinema()!="","c.cinema",cinemaVO.getCinema())
                .like(cinemaVO.getAddress()!="","c.address",cinemaVO.getAddress());
        return cinemaService.listCinemas(page,query);
    }

    @GetMapping("/getBrands")
    public List<Brand> getBrands(){
        return brandService.list();
    }

    @GetMapping("/listBrands")
    public IPage<Brand> listBrands(Integer currentPage,Integer pageSize,String brand){
        IPage<Brand> page = new Page<>(currentPage,pageSize);
        QueryWrapper<Brand> queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_deleted",0).eq(brand!="","id",brand==""?"":Integer.parseInt(brand));
        return brandService.page(page,queryWrapper);
    }

    @GetMapping("/getProvinceAndCityAndArea")
    public List<ProvinceVO> getProvinceAndCityAndArea(){
        List<ProvinceVO> provinceList = new ArrayList<>();
        List<Province> provinces = provinceService.list();
        for(Province province : provinces){
            ProvinceVO provinceVO = new ProvinceVO();
            provinceVO.setValue(Integer.parseInt(province.getCode()));
            provinceVO.setLabel(province.getName());

            List<CityVO> cityList = new ArrayList<>();
            QueryWrapper<City> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("province_code",province.getCode());
            List<City> cities = cityService.list(queryWrapper);
            for(City city : cities){
                CityVO cityVO = new CityVO();
                cityVO.setValue(Integer.parseInt(city.getCode()));
                cityVO.setLabel(city.getName());

                List<AreaVO> areaList = new ArrayList<>();
                QueryWrapper<Area> query = new QueryWrapper<>();
                query.eq("city_code",city.getCode());
                List<Area> areas = areaService.list(query);
                for (Area area : areas){
                    AreaVO areaVO = new AreaVO();
                    areaVO.setValue(Integer.parseInt(area.getCode()));
                    areaVO.setLabel(area.getName());
                    areaList.add(areaVO);
                }
                cityVO.setChildren(areaList);
                cityList.add(cityVO);
            }
            provinceVO.setChildren(cityList);
            provinceList.add(provinceVO);
        }
        return provinceList;
    }

    @GetMapping("/listAreas")
    public IPage<AreaDTO> listAreas(Integer currentPage, Integer pageSize){
        IPage<AreaDTO> page = new Page<>(currentPage,pageSize);
        return areaService.getAreas(page);
    }

    @GetMapping("/getAreaById")
    public IPage<AreaDTO> getAreaById(Integer currentPage, Integer pageSize,Integer id){
        IPage<AreaDTO> page = new Page<>(currentPage,pageSize);
        QueryWrapper<AreaDTO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("a.code",id);
        return areaService.getAreaById(page,queryWrapper);
    }

    @GetMapping("/listCities")
    public List<City> listCities(){
        return cityService.list();
    }

    //??????city???????????????????????????
    @GetMapping("/getBrandsByCity")
    public List<Brand> getBrandsByCity(String city){
        QueryWrapper query = new QueryWrapper();
        query.eq("c.name",city);
        return brandService.getBrandsByCity(query);
    }
    //??????city????????????????????????
    @GetMapping("/getAreasByCity")
    public List<Area> getAreasByCity(String city){
        QueryWrapper query = new QueryWrapper();
        query.eq("c.name",city);
        return areaService.getAreasByCity(query);
    }

    //??????????????????cinema??????
    @GetMapping("/listCinemaBySort")
    public List<Cinema> listCinemaBySort(String city,String brand,String area,String type,String sort){
        String str = "";
        if ("1".equals(sort)){
            str = "ci.is_rebook";
        }else {
            str = "ci.is_refund";
        }
        QueryWrapper<Cinema> query = new QueryWrapper();
        query.eq("ci.is_deleted",0)
                .eq("c.name",city)
                .eq(StringUtils.isNotBlank(brand),"b.brand",brand)
                .eq(StringUtils.isNotBlank(area),"a.name",area)
                .eq(StringUtils.isNotBlank(type),"rt.type",type)
                .eq(StringUtils.isNotBlank(sort),str,1).groupBy("ci.id");
        return cinemaService.listCinemaBySort(query);
    }
    //??????id??????????????????cinema?????????
    @GetMapping("/getCinemaById")
    public Cinema getCinemaById(Integer id){
        return cinemaService.getById(id);
    }

    //??????filmId???????????????????????????????????????????????????
    @GetMapping("/listCinemasByFilmId")
    public List<Cinema> listCinemasByFilmId(String filmId,String city,String brand,String area,String type,String sort){
        String str = "";
        if ("1".equals(sort)){
            str = "ci.is_rebook";
        }else {
            str = "ci.is_refund";
        }
        QueryWrapper<Cinema> query = new QueryWrapper();
        query.eq("ci.is_deleted",0)
                .eq("c.name",city)
                .eq(StringUtils.isNotBlank(brand),"b.brand",brand)
                .eq(StringUtils.isNotBlank(area),"a.name",area)
                .eq(StringUtils.isNotBlank(type),"rt.type",type)
                .eq(StringUtils.isNotBlank(sort),str,1)
                .eq(StringUtils.isNotBlank(filmId),"s.film_id",filmId).groupBy("ci.id");
        return cinemaService.listCinemasByFilmId(query);
    }
}
