package com.duing.controller;

import com.duing.config.VegetablesConfig;
import com.duing.domain.Food;
import com.duing.domain.Vegetables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hello Johnny";
    }
    @Autowired
    private VegetablesConfig vegetablesConfig;

    @RequestMapping("vegetables")
    public Vegetables vegetables(){
        Vegetables vegetables = new Vegetables();
        vegetables.setTomato(vegetablesConfig.getTomato());
        vegetables.setEggplant(vegetablesConfig.getEggplant());
        vegetables.setGreenpepper(vegetablesConfig.getGreenpepper());
        return vegetables;
    }

    @Value("${food.rice}")
    private String rice;
    @Value("${food.meat}")
    private String meat;

    @RequestMapping("food")
    public Food food(){
        Food food = new Food();
        food.setMeat(meat);
        food.setRice(rice);
        return food;
    }
}
