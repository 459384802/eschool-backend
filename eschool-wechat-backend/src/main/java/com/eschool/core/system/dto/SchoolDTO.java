package com.eschool.core.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 学校信息表
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@Data
public class SchoolDTO {
    private Integer id;
    /**
     * 学校名称
     */
	private String text;

	private Integer isDefault;
}
