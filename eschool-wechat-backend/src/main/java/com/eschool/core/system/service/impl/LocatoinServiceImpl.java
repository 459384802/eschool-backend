package com.eschool.core.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.system.mapper.LocatoinMapper;
import com.eschool.core.system.entity.LocatoinEntity;
import com.eschool.core.system.service.LocatoinService;


@Service("locatoinService")
public class LocatoinServiceImpl extends ServiceImpl<LocatoinMapper, LocatoinEntity> implements LocatoinService {

}
