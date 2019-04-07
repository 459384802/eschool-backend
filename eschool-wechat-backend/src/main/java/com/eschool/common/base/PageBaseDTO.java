package com.eschool.common.base;

import lombok.Data;

/**
 * @author yanghanchun
 * @date 2019/4/7 16:22
 * @Description:
 */
@Data
public class PageBaseDTO {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
