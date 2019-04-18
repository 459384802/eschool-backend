package com.eschool.core.message.controller;

import com.eschool.core.message.dto.MessageFormDTO;
import com.eschool.core.message.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eschool.core.message.service.MessageService;

import java.util.List;


/**
 * 留言信息
 *
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:32:50
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/save")
    public List<MessageEntity> save(@RequestBody MessageFormDTO dto){
        return messageService.saveMessage(dto);
    }
}
