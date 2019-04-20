package com.eschool.core.order.dto;

import com.eschool.common.utils.DateUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:28:25
 */
@Data
public class OrderListDTO {
    private Integer id;

    private Integer taskId;
    /**
     * 任务标题
     */
	private String taskTitle;
    /**
     * 任务类型：关联数据字典yhc_dictionarydata，dict_type=taskType
     */
	private Integer taskType;
    /**
     * 酬金
     */
	private BigDecimal fee;
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
     * 有效状态：0-无效1-有效
     */
	private Integer validStatus;

    /**
     * 任务有效剩余时间
     */
    private String timeRemaining;
    /**
     * 当前时间距离创建时间的时间间隔
     */
    private String createTimeInterval;

    public String getTimeRemaining() {
        return DateUtils.getTimeIntervalToStr(new Date(), deadlineTime);
    }

    public String getCreateTimeInterval() {
        return DateUtils.getSimpleTimeIntervalToStr(this.getCreateTime(), new Date());
    }
}
