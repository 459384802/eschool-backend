package com.eschool.core.task.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eschool.core.task.dto.TaskListDTO;
import com.eschool.core.task.dto.TaskSearchDTO;
import com.eschool.core.task.dto.TaskShowDTO;
import com.eschool.core.task.entity.TaskEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 任务信息
 * 
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:28:25
 */
@Mapper
public interface TaskMapper extends BaseMapper<TaskEntity> {
    /**
     * 根据id获取详情信息
     * @param id
     * @return
     */
    TaskShowDTO getInfoById(Integer id);

    /**
     * 分页获取任务列表信息
     * @param page
     * @param dto
     * @return
     */
    IPage<TaskListDTO> queryForList(Page<?> page,@Param("params") TaskSearchDTO dto);

    /**
     * 获取我的发布列表
     * @param objectPage
     * @param dto
     * @return
     */
    IPage<TaskListDTO> queryForReleaseList(Page<Object> objectPage,@Param("params") TaskSearchDTO dto);
}
