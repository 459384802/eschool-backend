package com.eschool.core.task.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class TaskFormDTO{
    private Integer id;

    /**
     * 任务标题
     */
    @NotEmpty(message = "任务标题不能为空")
	private String taskTitle;
    /**
     * 任务类型：关联数据字典yhc_dictionarydata，dict_type=taskType
     */
    @NotNull(message = "任务类型不能为空")
	private Integer taskType;

    @NotNull(message = "地区不能为空")
	private Integer schoolId;
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
     * 手机号码
     */
    @NotEmpty(message = "手机号码不能为空")
	private String phone;
    /**
     * 任务有效截止时间
     */
	private Date deadlineTime;
    /**
     * 任务状态：0-待接单 1-进行中 2-已完成 3-已确认
     */
    private Integer taskStatus;

}
