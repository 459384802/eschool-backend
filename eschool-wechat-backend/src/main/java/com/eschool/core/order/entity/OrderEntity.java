package com.eschool.core.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 任务订单表
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:31:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("yhc_order")
public class OrderEntity extends BaseEntity {

    /**
     * 任务id
     */
	private Integer taskId;
    /**
     * 接单用户id
     */
	private Integer userId;

    public OrderEntity() {
    }

    public OrderEntity(Integer taskId, Integer userId) {
        this.taskId = taskId;
        this.userId = userId;
    }
}
