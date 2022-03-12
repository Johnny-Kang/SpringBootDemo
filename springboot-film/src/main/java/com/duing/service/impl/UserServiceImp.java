package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.User;
import com.duing.mapper.UserMapper;
import com.duing.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
}
