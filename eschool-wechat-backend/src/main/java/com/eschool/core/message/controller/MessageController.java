package com.eschool.core.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eschool.core.message.service.MessageService;


/**
 * 留言信息
 *
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:32:50
 */
@RestController
@RequestMapping("/api/message/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

}
