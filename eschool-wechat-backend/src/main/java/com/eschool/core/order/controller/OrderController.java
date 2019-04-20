package com.eschool.core.order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eschool.common.utils.ContextUtil;
import com.eschool.core.order.dto.OrderListDTO;
import com.eschool.core.order.dto.OrderSearchDTO;
import com.eschool.core.order.entity.OrderEntity;
import com.eschool.core.task.dto.TaskListDTO;
import com.eschool.core.task.dto.TaskSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eschool.core.order.service.OrderService;

import java.util.List;


/**
 * 任务订单表
 *
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:31:02
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 我的接单：订单列表
     * @return
     */
    @PostMapping("/list")
    public IPage<OrderListDTO> list(@RequestBody OrderSearchDTO dto){
        dto.setPageSize(-1);
        dto.setUserId(ContextUtil.getCurrentUserId());
        return orderService.queryForList(dto);
    }

    /**
     * 接单
     */
    @PostMapping("/save")
    public void save(@RequestBody Integer taskId){
        orderService.saveOrder(taskId);
    }

    /**
     * 取消接单
     */
    @PostMapping("/remove")
    public void remove(@RequestBody Integer taskId){
        orderService.removeOrder(taskId);
    }
}
