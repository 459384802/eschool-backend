package com.eschool.core.login.dto;

import lombok.Data;

/**
 * @author yanghanchun
 * @date 2019/4/17 22:05
 * @Description:
 */
@Data
public class LoginParamDTO {
    private String code;
    private String userInfojson;
}
