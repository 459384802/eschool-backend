package com.eschool.core.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.common.exception.LoginException;
import com.eschool.common.utils.Constant;
import com.eschool.common.utils.ContextUtil;
import com.eschool.common.utils.UserCacheUtil;
import com.eschool.core.login.entity.WXSessionModel;
import com.eschool.core.system.dto.UserFormDTO;
import com.eschool.core.system.entity.SchoolEntity;
import com.eschool.core.system.entity.UserEntity;
import com.eschool.core.system.mapper.SchoolMapper;
import com.eschool.core.system.mapper.UserMapper;
import com.eschool.core.system.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public UserEntity getByOpenId(String openid) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid",openid);
        queryWrapper.eq("delete_status", Constant.DELETE_STATUS_NORMAL);
        List<UserEntity> userEntities = userMapper.selectList(queryWrapper);
        if(!CollectionUtils.isEmpty(userEntities)){
            return userEntities.get(0);
        }
        return null;
    }

    @Override
    public UserEntity createUser(WXSessionModel model, String userInfojson) {
        UserEntity userEntity = new UserEntity();
        userEntity.setOpenid(model.getOpenid());
        JSONObject jsonObject = JSON.parseObject(userInfojson);
        userEntity.setNickName(jsonObject.getString("nickName"));
        userEntity.setGender(jsonObject.getInteger("gender"));
        userEntity.setHeadImage(jsonObject.getString("avatarUrl"));
        userMapper.insert(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity updateCurrentUser(UserFormDTO dto) {
        UserEntity userEntity = userMapper.selectById(ContextUtil.getCurrentUserId());
        if(userEntity == null){
            throw new LoginException("当前用户已不存在");
        }
        userEntity.setProperty(dto);
        if(userEntity.getSchoolId() != null && StringUtils.isBlank(userEntity.getSchoolName())){
            SchoolEntity schoolEntity = schoolMapper.selectById(userEntity.getSchoolId());
            if(schoolEntity != null){
                userEntity.setSchoolName(schoolEntity.getName());
            }
        }
        userMapper.updateById(userEntity);
        //重新设置用户信息缓存
        UserEntity newUserEntity = userMapper.selectById(userEntity.getId());
        UserCacheUtil.putUserInfo(newUserEntity);
        return newUserEntity;
    }
}
