package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duing.domain.RoomType;
import com.duing.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roomInfo")
public class RoomInfoController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/getTypes")
    public List<RoomType> getTypes(){
        return roomTypeService.list();
    }

    @GetMapping("/listTypes")
    public IPage<RoomType> listRoomTypes(Integer currentPage,Integer pageSize,String type){
        IPage<RoomType> page = new Page<>(currentPage,pageSize);
        QueryWrapper<RoomType> queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_deleted",0).eq(type!="","id",type==""?"":Integer.parseInt(type));
        return  roomTypeService.page(page,queryWrapper);
    }

    //通过city得到所以影厅的类型
    @GetMapping("/getRoomTypeByCity")
    public List<RoomType> getRoomTypeByCity(String city){
        QueryWrapper query = new QueryWrapper();
        query.eq("c.name",city);
        return roomTypeService.getRoomTypeByCity(query);
    }
}
