package com.eschool.core.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.eschool.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 字典数据表
 * 
 * @author yanghanchun
 * @version 1.0
 * @date 2019-03-21 16:21:11
 */
@Data
@TableName("yhc_dictionarydata")
public class DictionarydataEntity{
    @TableId
    private Long id;
    /**
     * 字典名字：如性别
     */
	private String dictName;
    /**
     * 字典类型码：如sextype
     */
	private String dictType;
    /**
     * 键名：如男
     */
	private String dictdataName;
    /**
     * 键值：如1
     */
	private String dictdataValue;
    /**
     * 
     */
	private String dictdataDesc;

}
