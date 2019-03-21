package com.eschool.core.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eschool.core.notice.service.NoticeService;


/**
 * 
 *
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:29:36
 */
@RestController
@RequestMapping("/api/notice/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

}
