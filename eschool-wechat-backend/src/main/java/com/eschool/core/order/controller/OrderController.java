package com.eschool.core.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

}
