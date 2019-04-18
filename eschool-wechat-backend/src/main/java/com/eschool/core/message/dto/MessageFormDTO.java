package com.eschool.core.message.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yanghanchun
 * @date 2019/4/13 23:16
 * @Description:
 */
@Data
public class MessageFormDTO {
    private Integer replyerUserId;
    @NotEmpty(message = "非法的参数")
    private String content;
    @NotNull(message = "非法的参数")
    private Integer taskId;
}
