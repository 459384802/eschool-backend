package com.eschool.core.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eschool.core.system.service.UserService;


/**
 * 用户信息
 *
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@RestController
@RequestMapping("/api/system/user")
public class UserController {
    @Autowired
    private UserService userService;

}
