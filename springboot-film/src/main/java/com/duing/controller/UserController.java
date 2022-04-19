package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.duing.domain.User;
import com.duing.domain.vo.UserVO;
import com.duing.service.UserService;
import com.duing.service.impl.UserServiceImp;
import com.duing.util.MyUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;


@RestController
@RequestMapping("/userInfo")
public class UserController {
    @Autowired
    private UserServiceImp userService;

    @GetMapping("/listUsers")
    public IPage<User> listUsers( UserVO userVO){
        IPage<User> page = new Page<User>(userVO.getCurrentPage(),userVO.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_deleted",0)
                .eq(userVO.getRole()!=null,"role",userVO.getRole())
                .like(userVO.getUsername()!="","username",userVO.getUsername())
                .like(userVO.getPhone()!="","phone",userVO.getPhone())
                .like(userVO.getEmail()!="","email",userVO.getEmail())
                .like(userVO.getSex()!="","sex",userVO.getSex());
        return userService.page(page,queryWrapper);
    };


    @PostMapping("/login")
    public User login(User user){
        String password = null;
        try {
            password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("password",password).eq("role",user.getRole())
                .eq("is_deleted",0)
                .and(i -> i.eq("username", user.getUsername()).or().eq("phone", user.getUsername()));
        return userService.getOne(query);
    }
    @GetMapping("/getUserById")
    public User getUserById(Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/register")
    public Boolean register(User user){
        QueryWrapper<User> query = new QueryWrapper();
        query.eq("is_deleted",0).eq("phone",user.getPhone());
        if (userService.getOne(query) == null){
            try {
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            user.setUsername(MyUtil.getRandomNickname(10));
            user.setImgUrl("avatar.jpg");
            return userService.save(user);
        }
        return false;
    }

    @PostMapping("/deleteUserById")
    public void deleteUserById(@RequestBody HashMap<String,Object> data) {
        userService.removeById((Integer)data.get("id"));
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        try {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setImgUrl("avatar.jpg");
        userService.save(user);
    }
}
