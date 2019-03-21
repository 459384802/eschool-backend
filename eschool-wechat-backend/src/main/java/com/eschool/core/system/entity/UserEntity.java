package com.eschool.core.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户信息
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("yhc_user")
public class UserEntity extends BaseEntity {

    /**
     * 所属院校id
     */
	private Integer schoolId;
    /**
     * 所属院校名称
     */
	private String schoolName;
    /**
     * 登录用户名
     */
	private String username;
    /**
     * 登录密码
     */
	private String password;
    /**
     * 微信名称
     */
	private String wechatName;
    /**
     * 性别：1-男 2-女
     */
	private Integer gender;
    /**
     * 微信位置信息
     */
	private String wechatLocation;
    /**
     * 微信头像访问地址
     */
	private String wechatHeadImage;

}
