package com.eschool.core.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eschool.core.system.service.DictionarydataService;


/**
 * 字典数据表
 *
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@RestController
@RequestMapping("/api/system/dictionarydata")
public class DictionarydataController {
    @Autowired
    private DictionarydataService dictionarydataService;

}
