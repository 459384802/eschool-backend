package com.eschool.core.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eschool.core.system.dto.LocationSchoolDTO;
import com.eschool.core.system.entity.LocationEntity;

import java.util.List;

/**
 * 位置信息表
 *
 * @author yanghanchun
 * @email 459384802@qq.com
 * @date 2019-03-21 16:21:11
 */
public interface LocationService extends IService<LocationEntity> {

    List<LocationSchoolDTO> queryForList();
}

