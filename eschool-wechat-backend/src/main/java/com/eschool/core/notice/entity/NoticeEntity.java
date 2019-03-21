package com.eschool.core.notice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:29:36
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("yhc_notice")
public class NoticeEntity extends BaseEntity {

    /**
     * 通知类型：1-系统通知 2-用户通知
     */
	private Integer noticeType;
    /**
     * 通知内容
     */
	private String content;
    /**
     * 是用户通知时关联的任务id
     */
	private Integer taskId;
    /**
     * 是用户通知时关联的任务标题
     */
	private String taskTitle;
    /**
     * 回复者的用户id
     */
	private Integer replyerUserId;
    /**
     * 回复者的微信用户名称
     */
	private String replyerWecharName;

}
