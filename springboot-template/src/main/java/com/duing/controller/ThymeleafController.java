package com.duing.controller;

import com.duing.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
    @RequestMapping("thyme")
    public String thyme(Model model){
        Student student = new Student();
        student.setName("kpq");
        student.setSex("男");
        model.addAttribute("student",student);
        return "thymeleaf/index";
    }
}
