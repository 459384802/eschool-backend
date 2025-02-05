package com.eschool.common.utils;

import com.eschool.core.login.dto.SesssionDataDTO;
import com.eschool.core.system.entity.UserEntity;

/**
 * @author yanghanchun
 * @date 2019/4/6 18:33
 * @Description:
 */
public class UserCacheUtil {
    /**
     * 从缓存里获取登录的用户信息
     * @param userId
     * @return
     */
    public static UserEntity getUserInfo(Integer userId){
        Object obj = EhcacheUtil.getInstance().get(EhcacheUtil.USER_CACHE_NAME, EhcacheUtil.USER_CACHE_PREFIX + userId.toString());
        if(obj != null && obj instanceof UserEntity){
            return (UserEntity)obj;
        }
        return null;
    }

    /**
     * 将用户信息存放到缓存
     * @param userInfo
     */
    public static void putUserInfo(UserEntity userInfo){
        EhcacheUtil.getInstance().put(EhcacheUtil.USER_CACHE_NAME,EhcacheUtil.USER_CACHE_PREFIX + userInfo.getId(),userInfo);
    }

    /**
     * 从缓存里删除用户信息
     * @param userId
     */
    public static void removeSessionData(Integer userId){
        EhcacheUtil.getInstance().remove(EhcacheUtil.USER_CACHE_NAME,EhcacheUtil.USER_CACHE_PREFIX);
    }
}
