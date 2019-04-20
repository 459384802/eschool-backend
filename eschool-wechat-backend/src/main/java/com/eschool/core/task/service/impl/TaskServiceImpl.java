package com.eschool.core.task.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eschool.common.exception.CustomException;
import com.eschool.common.utils.Constant;
import com.eschool.common.utils.ContextUtil;
import com.eschool.common.validator.ValidatorUtils;
import com.eschool.core.system.entity.UserEntity;
import com.eschool.core.task.dto.TaskFormDTO;
import com.eschool.core.task.dto.TaskListDTO;
import com.eschool.core.task.dto.TaskSearchDTO;
import com.eschool.core.task.dto.TaskShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.task.mapper.TaskMapper;
import com.eschool.core.task.entity.TaskEntity;
import com.eschool.core.task.service.TaskService;
import org.springframework.transaction.annotation.Transactional;


@Service("taskService")
@Transactional
public class TaskServiceImpl extends ServiceImpl<TaskMapper, TaskEntity> implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public Integer saveOrUpdateTask(TaskFormDTO dto) {
        if(dto.getId() == null){
            ValidatorUtils.validateEntity(dto);
        }
        TaskEntity entity = new TaskEntity(dto);
        UserEntity currentUserInfo = ContextUtil.getCurrentUserInfo();
        if(dto.getId() == null){
            //新增
            entity.setUserId(currentUserInfo.getId());
            entity.setHeadImage(currentUserInfo.getHeadImage());
            taskMapper.insert(entity);
        }else{
            //编辑
            if(taskMapper.selectById(dto.getId()) == null){
                throw new CustomException("该任务已不存在");
            }
            entity.setId(dto.getId());
            taskMapper.updateById(entity);
        }
        return entity.getId();
    }

    @Override
    public TaskShowDTO getInfoById(Integer id) {
        return taskMapper.getInfoById(id);
    }

    @Override
    public IPage<TaskListDTO> queryForList(TaskSearchDTO dto) {
        return taskMapper.queryForList(new Page<>(dto.getPageNum(),dto.getPageSize()),dto);
    }

    @Override
    public IPage<TaskListDTO> queryForReleaseList(TaskSearchDTO dto) {
        return taskMapper.queryForReleaseList(new Page<>(dto.getPageNum(),dto.getPageSize()),dto);
    }
}
