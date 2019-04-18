package com.eschool.core.system.controller;

import com.eschool.core.system.dto.LocationSchoolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eschool.core.system.service.LocationService;

import java.util.List;


/**
 * 位置信息表
 *
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@RestController
@RequestMapping("/api/system/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/list")
    public List<LocationSchoolDTO> list(){
        return locationService.queryForList();
    }

}
