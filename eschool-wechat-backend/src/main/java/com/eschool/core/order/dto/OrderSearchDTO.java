package com.eschool.core.order.dto;

import com.eschool.common.base.PageBaseDTO;
import lombok.Data;

/**
 * @author yanghanchun
 * @date 2019/4/20 15:01
 * @Description:
 */
@Data
public class OrderSearchDTO extends PageBaseDTO {
    private Integer taskStatus;
    private Integer userId;
}
