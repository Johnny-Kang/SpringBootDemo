package com.duing.controller;

import com.duing.domain.DataBean;
import com.duing.domain.Graph;
import com.duing.service.DataService;
import com.duing.service.GraphService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;


@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private GraphService graphService;

    @GetMapping("/")
    public String list(Model model){
        List<DataBean> list = dataService.list();
        model.addAttribute("list",list);
        return "list";
    }

    @GetMapping("/graph")
    public String GraphList(Model model){
        List<Graph> graphs = graphService.list();
        List<String> dates = new ArrayList<>();
        List<Integer> confirms = new ArrayList<>();
        List<Integer> suspects = new ArrayList<>();
        for (Graph graph : graphs){
            String date = graph.getDate().replace(".","-");
            dates.add(date);
            confirms.add(graph.getConfirm());
            suspects.add(graph.getSuspect());
        }
        model.addAttribute("dates",dates);
        model.addAttribute("confirms",confirms);
        model.addAttribute("suspects",suspects);

        return "graph";
    }

    @GetMapping("/map")
    public String map(Model model){
        List<DataBean> list = dataService.list();
        JsonArray arr1 = new JsonArray();
        JsonArray arr2 = new JsonArray();
        for (DataBean bean : list){
            JsonObject obj1 = new JsonObject();
            obj1.addProperty("name",bean.getArea());
            obj1.addProperty("value",bean.getNowConfirm());
            arr1.add(obj1);
        }
        for (DataBean bean : list){
            JsonObject obj2 = new JsonObject();
            obj2.addProperty("name",bean.getArea());
            obj2.addProperty("value",bean.getConfirm());
            arr2.add(obj2);
        }
        model.addAttribute("data1",arr1.toString());
        model.addAttribute("data2",arr2.toString());
        return "myMap";
    }
}
