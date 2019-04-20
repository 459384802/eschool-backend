package com.eschool.core.order.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eschool.core.order.dto.OrderListDTO;
import com.eschool.core.order.dto.OrderSearchDTO;
import com.eschool.core.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eschool.core.task.dto.TaskListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 任务订单表
 * 
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:31:02
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
    /**
     * 获取订单列表
     * @param page
     * @param dto
     * @return
     */
    IPage<OrderListDTO> queryForList(Page<?> page, @Param("params") OrderSearchDTO dto);
}
