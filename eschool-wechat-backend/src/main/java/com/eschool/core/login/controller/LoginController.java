package com.eschool.core.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.eschool.common.exception.CustomException;
import com.eschool.common.utils.JwtUtil;
import com.eschool.common.utils.UserCacheUtil;
import com.eschool.common.utils.WechatUtil;
import com.eschool.core.login.dto.LoginParamDTO;
import com.eschool.core.login.dto.SesssionDataDTO;
import com.eschool.core.login.entity.WXSessionModel;
import com.eschool.core.system.entity.UserEntity;
import com.eschool.core.system.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private WechatUtil wechatUtil;
    @Autowired
    private UserService userService;

    @PostMapping("/wxlogin")
    public SesssionDataDTO login(@RequestBody LoginParamDTO param){
        //访问code2Session微信登录凭证校验接口
//        WXSessionModel model = wechatUtil.code2Session(param.getCode());
//        if(!WXSessionModel.ERR_CODE_SUCCESS.equals(model.getErrcode())){
//            throw new CustomException("系统繁忙，请稍候再试");
//        }
        WXSessionModel model = new WXSessionModel("1","session_key");
        //微信登录成功
        UserEntity userEntity = userService.getByOpenId(model.getOpenid());
        //第一次登陆要创建用户
        if(userEntity == null){
            userEntity = userService.createUser(model,param.getUserInfojson());
        }
        //生成token
        String token = getLoginToken(userEntity.getId(),model.getSession_key());
        //用户信息缓存
        UserCacheUtil.putUserInfo(userEntity);
        SesssionDataDTO sesssionDataDTO = new SesssionDataDTO(token, userEntity);
        return sesssionDataDTO;
    }

    /**
     * 使用JWT签发token
     * @param userId
     * @param session_key
     * @return
     */
    private String getLoginToken(Integer userId, String session_key) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("userId",userId);
        map.put("session_key",session_key);
        try {
           return JwtUtil.createJWT(map, null);
        } catch (JsonProcessingException e) {
            throw new CustomException("创建JWT令牌异常："+e.getMessage(), e);
        }
    }
}
