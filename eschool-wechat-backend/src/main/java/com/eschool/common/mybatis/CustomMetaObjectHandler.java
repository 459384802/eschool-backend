package com.eschool.common.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.eschool.common.utils.ContextUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenqibo
 * @date 2018-12-17 19:18
 * @description: 自定义填充策略接口实现
 */
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            Object delFlag = getFieldValByName("deleteStatus", metaObject);
            if (null == delFlag) {
                setFieldValByName("deleteStatus", 0, metaObject);
            }
        } catch (Exception e) {
            logger.error("插入deleteStatus字段异常", e);
        }
        try {
            Object delFlag = getFieldValByName("updateUser", metaObject);
            if (null == delFlag) {
                //获取当前登录用户
                Object userId = String.valueOf(ContextUtil.getFromSession("userId"));
                userId = (userId == null ? "0" : userId).toString();
                setFieldValByName("updateUser", userId, metaObject);
            }
        } catch (Exception e) {
            logger.error("插入updateUser字段异常", e);
        }
        try {
            Object delFlag = getFieldValByName("createUser", metaObject);
            if (null == delFlag) {
                //获取当前登录用户
                Object userId = String.valueOf(ContextUtil.getFromSession("userId"));
                userId = (userId == null ? "0" : userId).toString();
                setFieldValByName("createUser", userId, metaObject);
            }
        } catch (Exception e) {
            logger.error("插入updateUser字段异常", e);
        }
        try {
            Object createTime = getFieldValByName("createTime", metaObject);
            if (null == createTime) {
                setFieldValByName("createTime", new Date(), metaObject);
            }
        } catch (Exception e) {
            logger.error("插入createTime字段异常", e);
        }
        try {
            Object createTime = getFieldValByName("updateTime", metaObject);
            if (null == createTime) {
                setFieldValByName("updateTime", new Date(), metaObject);
            }
        } catch (Exception e) {
            logger.error("插入updateTime字段异常", e);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        try {
            Object updateTime = getFieldValByName("updateTime", metaObject);
            if (null == updateTime) {
                setFieldValByName("updateTime", new Date(), metaObject);
            }
        } catch (ReflectionException e) {
            logger.error("更新updateTime字段异常", e);
        }

        try {
            Object delFlag = getFieldValByName("updateUser", metaObject);
            if (null == delFlag) {
                Object userId = String.valueOf(ContextUtil.getFromSession("userId"));
                userId = (userId == null ? "0" : userId).toString();
                setFieldValByName("updateUser", userId, metaObject);
            }
        } catch (Exception e) {
            logger.error("更新updateUser字段异常", e);
        }
    }
}
