package com.eschool.core.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eschool.common.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.system.mapper.UserMapper;
import com.eschool.core.system.entity.UserEntity;
import com.eschool.core.system.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getByOpenId(String openid) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid",openid);
        queryWrapper.eq("delete_status", Constant.DELETE_STATUS_NORMAL);
        return userMapper.selectOne(queryWrapper);
    }
}
