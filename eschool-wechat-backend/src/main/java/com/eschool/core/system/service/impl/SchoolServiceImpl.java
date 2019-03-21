package com.eschool.core.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.system.mapper.SchoolMapper;
import com.eschool.core.system.entity.SchoolEntity;
import com.eschool.core.system.service.SchoolService;


@Service("schoolService")
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, SchoolEntity> implements SchoolService {

}
