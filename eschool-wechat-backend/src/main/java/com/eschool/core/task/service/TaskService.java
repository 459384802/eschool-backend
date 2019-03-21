package com.eschool.core.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eschool.core.task.dto.TaskFormDTO;
import com.eschool.core.task.entity.TaskEntity;

import java.util.Map;

/**
 * 任务信息
 *
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:28:25
 */
public interface TaskService extends IService<TaskEntity> {
    /**
     * 发布/编辑任务
     * @param dto
     */
    void saveOrUpdateTask(TaskFormDTO dto);
}

