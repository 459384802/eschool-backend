package com.eschool.core.message.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 留言信息
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:32:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("yhc_message")
public class MessageEntity extends BaseEntity {

    /**
     * 所属任务id
     */
	private Integer taskId;
    /**
     * 留言者用户id
     */
	private Integer userId;
    /**
     * 留言者所属院校名称
     */
	private String userSchoolName;
    /**
     * 留言者微信名称
     */
	private String userWechatName;
    /**
     * 留言者微信头像访问地址
     */
	private String userWechatHeadImage;
    /**
     * 被回复的用户id，为空表示为直接留言
     */
	private Integer replyerUserId;
    /**
     * 被回复者的微信名称
     */
	private String replyerWechatName;
    /**
     * 留言信息内容
     */
	private String message;

}
