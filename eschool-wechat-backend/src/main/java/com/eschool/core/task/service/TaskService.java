package com.eschool.core.task.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eschool.core.task.dto.TaskFormDTO;
import com.eschool.core.task.dto.TaskListDTO;
import com.eschool.core.task.dto.TaskSearchDTO;
import com.eschool.core.task.dto.TaskShowDTO;
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
    Integer saveOrUpdateTask(TaskFormDTO dto);

    /**
     * 根据id获取详情信息
     * @param id
     * @return
     */
    TaskShowDTO getInfoById(Integer id);

    /**
     * 分页获取任务列表信息
     * @param dto
     * @return
     */
    IPage<TaskListDTO> queryForList(TaskSearchDTO dto);

    /**
     * 获取我的发布列表
     * @param dto
     * @return
     */
    IPage<TaskListDTO> queryForReleaseList(TaskSearchDTO dto);
}

