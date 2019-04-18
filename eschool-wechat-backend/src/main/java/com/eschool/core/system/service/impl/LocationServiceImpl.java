package com.eschool.core.system.service.impl;

import com.eschool.core.system.dto.LocationSchoolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.system.mapper.LocationMapper;
import com.eschool.core.system.entity.LocationEntity;
import com.eschool.core.system.service.LocationService;

import java.util.List;


@Service("locationService")
public class LocationServiceImpl extends ServiceImpl<LocationMapper, LocationEntity> implements LocationService {
    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<LocationSchoolDTO> queryForList() {
        return locationMapper.queryForList();
    }
}
