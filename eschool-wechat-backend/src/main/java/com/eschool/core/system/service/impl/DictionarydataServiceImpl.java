package com.eschool.core.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.system.mapper.DictionarydataMapper;
import com.eschool.core.system.entity.DictionarydataEntity;
import com.eschool.core.system.service.DictionarydataService;


@Service("dictionarydataService")
public class DictionarydataServiceImpl extends ServiceImpl<DictionarydataMapper, DictionarydataEntity> implements DictionarydataService {

}
