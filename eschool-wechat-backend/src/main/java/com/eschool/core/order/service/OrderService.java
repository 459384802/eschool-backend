package com.eschool.core.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eschool.core.order.entity.OrderEntity;

import java.util.Map;

/**
 * 任务订单表
 *
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:31:02
 */
public interface OrderService extends IService<OrderEntity> {
    /**
     * 当前用户接单
     * @param taskId
     */
    void saveOrder(Integer taskId);

    /**
     * 当前用户取消接单
     * @param taskId
     */
    void removeOrder(Integer taskId);
}

