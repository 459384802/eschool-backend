package com.eschool.core.task.mapper;

import com.eschool.core.task.entity.TaskEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 任务信息
 * 
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:28:25
 */
@Mapper
public interface TaskMapper extends BaseMapper<TaskEntity> {
	
}
