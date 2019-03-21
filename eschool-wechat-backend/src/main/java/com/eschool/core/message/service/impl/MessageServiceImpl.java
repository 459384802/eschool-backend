package com.eschool.core.message.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.message.mapper.MessageMapper;
import com.eschool.core.message.entity.MessageEntity;
import com.eschool.core.message.service.MessageService;


@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageEntity> implements MessageService {

}
