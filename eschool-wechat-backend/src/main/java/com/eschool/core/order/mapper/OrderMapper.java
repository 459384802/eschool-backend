package com.eschool.core.order.mapper;

import com.eschool.core.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 任务订单表
 * 
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:31:02
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
	
}
