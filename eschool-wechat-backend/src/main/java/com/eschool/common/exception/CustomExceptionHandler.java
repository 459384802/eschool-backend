package com.eschool.common.exception;

import com.eschool.common.base.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.ws.WebServiceException;

/**
 * @Auther: Aaron
 * @Date: 2018-11-14 09:11:56
 * @Description: 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(CustomException.class)
	public DataResponse<?> handleCustomException(CustomException e){
		log.error("业务系统异常", e);
		return new DataResponse<>(500, e.getMessage());
	}

	@ExceptionHandler(LoginException.class)
	public DataResponse<?> handleLoginException(LoginException e){
		log.error("登录异常", e);
		return new DataResponse<>(501, "token验证不通过");
	}

	@ExceptionHandler(RuntimeException.class)
	public DataResponse<?> handleException(RuntimeException e){
		if(e instanceof IndexOutOfBoundsException) {
			log.error("访问下标越界", e);
			return new DataResponse<>(500, "下标越界：" + e.getMessage());
		} else if (e instanceof DuplicateKeyException) {
			log.error("数据库重复主键", e);
			return new DataResponse<>(500, "数据库重复主键");
		} else if (e instanceof WebServiceException) {
			log.error("WebService异常", e);
			return new DataResponse<>(500, "WebService连接超时", null);
		} else {
			logger.error("运行时异常", e);
			return new DataResponse<>(500, e.getMessage());
		}
	}
	
	@ExceptionHandler(Exception.class)
	public DataResponse<?> handleException(Exception e){
		if (e instanceof HttpRequestMethodNotSupportedException) {
			log.error("method 方法不支持", e);
			return new DataResponse<>(500, e.getMessage());
		} else if (e instanceof HttpMediaTypeNotSupportedException) {
			log.error("不支持媒体类型", e);
			return new DataResponse<>(500, e.getMessage());
		} else {
			logger.error("后台异常", e);
			return new DataResponse<>(500, e.getMessage());
		}
	}
	
}
