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
	public static Integer getCurrentUserId(){
		return (Integer)getFromSession("userId");
	}

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
	 *  转化字符串id（逗号分隔）为Integer数组
	 * 如"1,2,3,4"转成Integer类型数组[1,2,3,4]
	 * @param ids
	 * @return
	 */
	public static Integer[] toIntegerArray(String ids) {
		return Arrays.stream(ids.split(",")).map(id -> Integer.valueOf(id)).toArray(Integer[]::new);
	}
	
	public static void main(String[] args) {
		String ids= "1,2,3,4,5,6";
		Integer[] aaa = toIntegerArray(ids);
		Arrays.stream(aaa).forEach(System.out::println);
	}

}
