package com.eschool.core.task.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 任务信息
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:28:25
 */
@Data
public class TaskShowDTO {
    private Integer id;
    /**
     * 任务发起人id
     */
	private Integer userId;
    /**
     * 任务发起人的微信名称
     */
	private String userWechatName;
    /**
     * 任务标题
     */
	private String taskTitle;
    /**
     * 任务类型：关联数据字典yhc_dictionarydata，dict_type=taskType
     */
	private Integer taskType;
    /**
     * 任务详细内容
     */
	private String taskContent;
    /**
     * 性别限制：0-男女不限 1-仅限男性 2-仅限女性
     */
	private Integer taskGender;
    /**
     * 备注
     */
	private String remark;
    /**
     * 酬金
     */
	private BigDecimal fee;
    /**
     * 联系方式
     */
	private String phone;
    /**
     * 任务有效截止时间
     */
	private Date deadlineTime;
    /**
     * 任务发布时间
     */
	private Date createTime;
    /**
     * 任务状态：0-待接单 1-进行中 2-已完成 3-已确认
     */
	private Integer taskStatus;

    /**
     * 任务有效剩余时间
     */
    private String timeRemaining;
    /**
     * 当前时间距离创建时间的时间间隔
     */
    private String createTimeInterval;

    public String getTimeRemaining() {
        return timeRemaining;
    }

    public String getCreateTimeInterval() {
        return createTimeInterval;
    }
}
