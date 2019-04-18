package com.eschool.core.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eschool.core.message.dto.MessageFormDTO;
import com.eschool.core.message.entity.MessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 留言信息
 *
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:32:50
 */
public interface MessageService extends IService<MessageEntity> {
    /**
     * 新增留言，并返回该任务的所有留言
     * @param dto
     * @return
     */
    List<MessageEntity> saveMessage(MessageFormDTO dto);
}

