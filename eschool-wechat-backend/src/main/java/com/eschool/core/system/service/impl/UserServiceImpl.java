package com.eschool.core.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.system.mapper.UserMapper;
import com.eschool.core.system.entity.UserEntity;
import com.eschool.core.system.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
