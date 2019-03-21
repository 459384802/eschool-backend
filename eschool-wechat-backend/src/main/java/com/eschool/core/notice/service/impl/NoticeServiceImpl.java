package com.eschool.core.notice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eschool.core.notice.mapper.NoticeMapper;
import com.eschool.core.notice.entity.NoticeEntity;
import com.eschool.core.notice.service.NoticeService;


@Service("noticeService")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, NoticeEntity> implements NoticeService {

}
