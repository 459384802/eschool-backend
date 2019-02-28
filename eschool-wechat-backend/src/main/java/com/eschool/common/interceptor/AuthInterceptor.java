package com.eschool.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限拦截器
 * @author chenqibo
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
	private List<String> normalUrlList = new ArrayList<>();
	private List<String> whitelist = new ArrayList<>();
	{
		// 增加白名单（匹配url全字符串）
		addNormalUrl("/api/login/sso");
        addNormalUrl("/api/login/appLogin");
        addNormalUrl("/api/login/appSSOLogin");
        addNormalUrl("/api/login/binding");
        addNormalUrl("/api/logout/sso");
		// 增加白名单（匹配url前缀）
        addWhitelistUrl("/api/async");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 验证白名单
		String servletPath = request.getServletPath();
		if (testWhiteList(servletPath)) {
			return true;
		}
		//TODO 权限验证
		return true;
	}
	
	/**
	 * 校验是否在百名单列表内
	 * @param servletPath
	 * @return
	 */
	private boolean testWhiteList(String servletPath) {
		if (normalUrlList.contains(servletPath)) {
			return true;
		}
        for (String whitelistItem : whitelist) {
            if (servletPath.startsWith(whitelistItem)) {
                return true;
            }
        }
		return false;
	}
	
	private void addNormalUrl(String normalUrl) {
        normalUrlList.add(normalUrl);
	}
	
	private void addWhitelistUrl(String whitelistItem) {
		whitelist.add(whitelistItem);
	}

	
}