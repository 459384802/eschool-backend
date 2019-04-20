package com.eschool.core.task.dto;

import com.eschool.common.base.PageBaseDTO;
import com.eschool.common.utils.Constant;
import com.eschool.common.utils.DateUtils;
import lombok.Data;

import java.util.Date;

/**
 * 任务信息
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:28:25
 */
@Data
public class TaskSearchDTO extends PageBaseDTO {
    private Integer taskType;
    private Integer taskGender;
    private Integer timeOrder;
    private Integer moneyOrder;
    private Integer schoolId;
    private Integer userId;
}
