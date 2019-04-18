package com.eschool.core.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 位置信息表
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("yhc_location")
public class LocationEntity extends BaseEntity {

    /**
     * 城市名称
     */
	private String name;

}
