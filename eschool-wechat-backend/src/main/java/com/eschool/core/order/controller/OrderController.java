package com.eschool.core.order.controller;

import com.eschool.core.order.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eschool.core.order.service.OrderService;


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
