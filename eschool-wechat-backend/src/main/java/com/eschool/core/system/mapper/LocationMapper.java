package com.eschool.core.system.mapper;

import com.eschool.core.system.dto.LocationSchoolDTO;
import com.eschool.core.system.entity.LocationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 位置信息表
 * 
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:21:11
 */
@Mapper
public interface LocationMapper extends BaseMapper<LocationEntity> {

    List<LocationSchoolDTO> queryForList();
}
