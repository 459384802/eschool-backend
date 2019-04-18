package com.eschool.core.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@Data
public class UserFormDTO {
    private Integer id;
    /**
     * 登录用户名
     */
    private String username;
    /**
     * 微信号
     */
    private String weixinNumber;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 所属院校id
     */
	private Integer schoolId;
    /**
     * 所属院校名称
     */
	private String schoolName;
    /**
     * 微信名称
     */
	private String nickName;
    /**
     * 性别：1-男 2-女
     */
	private Integer gender;
    /**
     * 微信头像访问地址
     */
	private String headImage;
    /**
     * 用户信用度
     */
	private Integer creditLine;
    /**
     * 院系
     */
	private String faculty;
    /**
     * 专业
     */
	private String major;
    /**
     * 真实姓名
     */
	private String realName;
    /**
     * 年级
     */
	private String userClass;
    /**
     * 联系电话
     */
	private String phone;

}
