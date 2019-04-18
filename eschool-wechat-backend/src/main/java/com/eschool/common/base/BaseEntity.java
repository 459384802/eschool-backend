package com.eschool.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author chenqibo
 * @version 1.0
 * @date 2018/12/17 3:38 PM
 */
@Data
public class BaseEntity implements Serializable {
    @TableId
    private Integer id;
    /**
     * 删除状态，0正常，1为逻辑删除
     */
    @TableField(value = "delete_status",fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteStatus;
    /**
     * 创建人
     */
    @TableField(value = "create_user",fill = FieldFill.INSERT)
    private Integer createUser;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新人
     */
    @TableField(value = "update_user",fill = FieldFill.INSERT_UPDATE)
    private Integer updateUser;
    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
