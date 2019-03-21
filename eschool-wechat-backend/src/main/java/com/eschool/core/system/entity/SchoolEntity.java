package com.eschool.core.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 学校信息表
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("yhc_school")
public class SchoolEntity extends BaseEntity {

    /**
     * 所属城市id
     */
	private Integer locationId;
    /**
     * 学校名称
     */
	private String name;
    /**
     * 学校中心点经度
     */
	private Double log;
    /**
     * 学校中心点纬度
     */
	private Double lat;
    /**
     * 学校范围半径
     */
	private Integer radius;

}
