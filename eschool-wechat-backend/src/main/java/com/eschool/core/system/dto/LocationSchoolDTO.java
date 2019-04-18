package com.eschool.core.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 位置信息表
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@Data
public class LocationSchoolDTO {
    private Integer id;
    /**
     * 城市名称
     */
	private String name;

	private List<SchoolDTO> schoolList;
}
