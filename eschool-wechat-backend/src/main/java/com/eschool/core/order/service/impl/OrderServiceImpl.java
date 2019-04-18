package com.eschool.core.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eschool.common.exception.CustomException;
import com.eschool.common.utils.Constant;
import com.eschool.common.utils.ContextUtil;
import com.eschool.core.task.entity.TaskEntity;
import com.eschool.core.task.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.order.mapper.OrderMapper;
import com.eschool.core.order.entity.OrderEntity;
import com.eschool.core.order.service.OrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service("orderService")
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void saveOrder(Integer taskId) {
        //校验
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("task_id",taskId);
        queryWrapper.eq("delete_status",Constant.DELETE_STATUS_NORMAL);
        List<OrderEntity> list = orderMapper.selectList(queryWrapper);
        if(!CollectionUtils.isEmpty(list)){
            throw new CustomException("该任务已被接单，操作失败！");
        }
        //接单操作
        Integer currentUserId = ContextUtil.getCurrentUserId();
        OrderEntity orderEntity = new OrderEntity(taskId,currentUserId);
        orderMapper.insert(orderEntity);
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(taskId);
        taskEntity.setTaskStatus(Constant.TASK_STATUS_DOING);
        taskMapper.updateById(taskEntity);
    }

    @Override
    public void removeOrder(Integer taskId) {
        Integer currentUserId = ContextUtil.getCurrentUserId();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDeleteStatus(Constant.DELETE_STATUS_DELETED);
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",currentUserId);
        queryWrapper.eq("task_id",taskId);
        orderMapper.update(orderEntity,queryWrapper);
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(taskId);
        taskEntity.setTaskStatus(Constant.TASK_STATUS_WAIT);
        taskMapper.updateById(taskEntity);
    }
}
