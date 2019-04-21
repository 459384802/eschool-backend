package com.eschool.core.login.entity;

import lombok.Data;

@Data
public class WXSessionModel {
    /**
     * 系统繁忙，此时请开发者稍候再试
     */
    public static final Integer ERR_CODE_BUSY = -1;

    /**
     * 会话密钥
     */
    private String session_key;
    /**
     * 用户唯一标识
     */
    private String openid;
    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
     */
    private String unionid;
    /**
     * 错误码：0-成功
     */
    private String errcode;
    /**
     * 错误信息
     */
    private String errmsg;

    public WXSessionModel() {
    }

    public WXSessionModel(String openid, String session_key) {
        this.openid = openid;
        this.session_key = session_key;
    }
}
