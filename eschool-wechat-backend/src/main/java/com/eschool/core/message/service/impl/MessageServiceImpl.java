package com.eschool.core.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eschool.common.utils.Constant;
import com.eschool.common.utils.ContextUtil;
import com.eschool.common.validator.ValidatorUtils;
import com.eschool.core.message.dto.MessageFormDTO;
import com.eschool.core.system.entity.UserEntity;
import com.eschool.core.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.message.mapper.MessageMapper;
import com.eschool.core.message.entity.MessageEntity;
import com.eschool.core.message.service.MessageService;

import java.util.List;


@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageEntity> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<MessageEntity> saveMessage(MessageFormDTO dto) {
        ValidatorUtils.validateEntity(dto);
        //新增留言
        Integer replyerUserId = dto.getReplyerUserId();
        UserEntity currentUserInfo = ContextUtil.getCurrentUserInfo();
        MessageEntity messageEntity = new MessageEntity();
        if(replyerUserId != null){
            UserEntity replyer = userMapper.selectById(replyerUserId);
            messageEntity.setReplyerUserId(replyerUserId);
            messageEntity.setReplyerNickName(replyer.getNickName());
        }
        messageEntity.setTaskId(dto.getTaskId());
        messageEntity.setContent(dto.getContent());
        messageEntity.setSenderHeadImage(currentUserInfo.getHeadImage());
        messageEntity.setSenderNickName(currentUserInfo.getNickName());
        messageEntity.setSenderSchoolName(currentUserInfo.getSchoolName());
        messageEntity.setSenderUserId(currentUserInfo.getId());
        messageMapper.insert(messageEntity);
        //获取当前任务的所有留言
        QueryWrapper<MessageEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("task_id",dto.getTaskId());
        queryWrapper.eq("delete_status", Constant.DELETE_STATUS_NORMAL);
        return messageMapper.selectList(queryWrapper);
    }
}
