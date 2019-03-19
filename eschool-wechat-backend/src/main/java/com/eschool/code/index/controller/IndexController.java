package com.eschool.code.index.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghanchun
 * @date 2019/3/7 15:35
 * @Description:
 */
@RestController
@RequestMapping("/api/index")
public class IndexController {

    @GetMapping("/list")
    public String list(@RequestParam(required = false) String title){
        return "标题pro：" + title;
    }
}
