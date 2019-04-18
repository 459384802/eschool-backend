package com.eschool.core.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eschool.core.login.entity.WXSessionModel;
import com.eschool.core.system.dto.UserFormDTO;
import com.eschool.core.system.entity.UserEntity;

import java.util.Map;

/**
 * 用户信息
 *
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:21:11
 */
public interface UserService extends IService<UserEntity> {
    /**
     * 根据微信的openid获取用户信息
     * @param openid
     * @return
     */
    UserEntity getByOpenId(String openid);

    /**
     * 创建用户
     * @param model
     * @param userInfojson
     * @return
     */
    UserEntity createUser(WXSessionModel model, String userInfojson);

    /**
     * 编辑当前用户
     * @param dto
     */
    UserEntity updateCurrentUser(UserFormDTO dto);
}

