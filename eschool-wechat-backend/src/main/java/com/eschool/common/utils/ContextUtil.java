package com.eschool.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 * 获取上下文session
 * @author chenqibo
 */
public class ContextUtil {
	
	/**
	 * @Description: 获取当前登录用户的主键id
	 * @return 返回Long类型用户id
	 */
	public static Long getCurrentUserId(){
		return (Long)getFromSession("userId");
	}

	/**
	 * 获取经销商id
	 * @return long
	 */
	public static Long getDealerId() {
		Object dealerId = getFromSession("dealerId");
		return (Long) dealerId;
	}
	
//	/**
//	 * 获取登录用户实体
//	 * @return
//	 */
//	public static SSOLoginVo getUserInfo() {
//		String userInfoJson = (String) getFromSession("userInfoJson");
//		return userInfoJson == null ? null :JSON.parseObject(userInfoJson, SSOLoginVo.class);
//	}

	/**
	 * @Description: 根据key从session获取信息
	 * @param key
	 * @return
	 */
    public static Object getFromSession (String key) {
		HttpSession session = getSession();
		if (session == null) {
			return null;
		}
		return session.getAttribute(key);
    }

    public static HttpServletRequest getRequest() {

		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (servletRequestAttributes == null) {
			return null;
		}
		return servletRequestAttributes.getRequest();
    }

    public static HttpSession getSession() {
		HttpServletRequest request = getRequest();
		if (request == null) {
			return null;
		}
		return request.getSession();
    }
	
	/**
	  *  转化字符串id（逗号分隔）为Long数组
	  * 如"1,2,3,4"转成Long类型数组[1,2,3,4]
	 * @param ids
	 * @return
	 */
	public static Long[] toLongArray(String ids) {
		return Arrays.stream(ids.split(",")).map(id -> Long.valueOf(id)).toArray(Long[]::new);
	}
	
	public static void main(String[] args) {
		String ids= "1,2,3,4,5,6";
		Long[] aaa = toLongArray(ids);
		Arrays.stream(aaa).forEach(System.out::println);
	}

}
