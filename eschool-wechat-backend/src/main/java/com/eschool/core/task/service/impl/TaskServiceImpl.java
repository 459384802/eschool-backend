package com.eschool.core.task.service.impl;

import com.eschool.common.exception.CustomException;
import com.eschool.common.utils.Constant;
import com.eschool.common.utils.ContextUtil;
import com.eschool.core.task.dto.TaskFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.task.mapper.TaskMapper;
import com.eschool.core.task.entity.TaskEntity;
import com.eschool.core.task.service.TaskService;


@Service("taskService")
public class TaskServiceImpl extends ServiceImpl<TaskMapper, TaskEntity> implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void saveOrUpdateTask(TaskFormDTO dto) {
        TaskEntity entity = new TaskEntity(dto);
        if(dto.getId() == null){
            //新增
            entity.setUserId(ContextUtil.getCurrentUserId());
            taskMapper.insert(entity);
        }else{
            //编辑
            if(taskMapper.selectById(dto.getId()) == null){
                throw new CustomException("该任务不存在");
            }
            entity.setId(dto.getId());
            taskMapper.updateById(entity);
        }


    }
}
