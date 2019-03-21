package com.eschool.core.system.mapper;

import com.eschool.core.system.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息
 * 
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:21:11
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
