package com.eschool.core.system.controller;

import com.eschool.core.system.dto.UserFormDTO;
import com.eschool.core.system.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/edit")
    public UserEntity edit(@RequestBody UserFormDTO dto){
        return userService.updateCurrentUser(dto);
    }

    @GetMapping("/show")
    public UserEntity show(@RequestParam Integer userId){
        return userService.getById(userId);
    }
}
