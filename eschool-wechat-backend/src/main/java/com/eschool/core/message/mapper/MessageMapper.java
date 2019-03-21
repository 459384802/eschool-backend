package com.eschool.core.message.mapper;

import com.eschool.core.message.entity.MessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 留言信息
 * 
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:32:50
 */
@Mapper
public interface MessageMapper extends BaseMapper<MessageEntity> {
	
}
