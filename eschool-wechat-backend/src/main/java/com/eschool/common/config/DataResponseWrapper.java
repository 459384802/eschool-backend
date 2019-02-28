package com.eschool.common.config;

import com.alibaba.fastjson.JSON;
import com.eschool.common.base.DataResponse;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回数据包装
 *
 * @author chenqibo
 * @version 1.0
 * @date 2018/12/15 4:18 PM
 */
@Aspect
@RestControllerAdvice(value = "com.eschool")
public class DataResponseWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof DataResponse) {
            return o;
        } else if (o instanceof String) {
            //对String类型作处理 不然会报错
            DataResponse<Object> dataResponse = new DataResponse<>(200, "success", o);
            return JSON.toJSONString(dataResponse);
        } else {
            return new DataResponse<>(200, "success", o);
        }
    }
}
