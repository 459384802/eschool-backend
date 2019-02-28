package com.eschool.common.utils;

/**
 * Created by @author songjhh on 2018/8/31
 */
public class ResponseCode {

    // 请求成功
    public static final int SUCCESS = 0;

    // 请求失败
    public static final int FAIL = -1;

    // Http请求成功
    public static final int OK = 200;

    // 找不到页面
    public static final int NotFound = 404;

    // 未授权
    public static final int Unauthorized = 401;

    // 无效session
    public static final int ERRORCODE_INVALID_SESSION = 999;

    // 未登陆
    public static final int ISLOGIN = 998;

}
