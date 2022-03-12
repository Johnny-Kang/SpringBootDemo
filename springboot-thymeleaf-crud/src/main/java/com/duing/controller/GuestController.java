package com.duing.controller;

import com.duing.domain.Guest;
import com.duing.service.GuestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GuestController {
    @Autowired
    private GuestServiceImpl guestService;

    @RequestMapping("/guest/list")
    public String guestList(Model model){
        List<Guest> guestList = guestService.GuestList();
        model.addAttribute("guestList",guestList);
        return "guestList";
    }

    @RequestMapping("/guest/toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("/guest/add")
    public String add(Guest guest){
        guestService.add(guest);
        return "redirect:/guest/list";
    }

    @RequestMapping("/guest/toUpdate")
    public String toUpdate(Model model,String name){
        Guest guest = guestService.get(name);
        model.addAttribute("guest",guest);
        return "update";
    }

    @RequestMapping("/guest/update")
    public String update(Guest guest){
        guestService.update(guest);
        return "redirect:/guest/list";
    }

    @RequestMapping("/guest/delete")
    public String delete(String name){
        guestService.delete(name);
        return "redirect:/guest/list";
    }
}
