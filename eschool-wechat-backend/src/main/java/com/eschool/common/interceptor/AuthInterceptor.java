package com.eschool.common.interceptor;

import com.eschool.common.exception.LoginException;
import com.eschool.common.utils.JwtUtil;
import com.eschool.common.utils.UserCacheUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
		//addNormalUrl("/api/login/login");
		// 增加白名单（匹配url前缀）
        addWhitelistUrl("/api/login");
	}

	/**
	 * 登录拦截，将当前登录的用户信息存放到session
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 验证白名单
		String servletPath = request.getServletPath();
		if (testWhiteList(servletPath)) {
			return true;
		}
		//token验证
		String token = request.getHeader("token");
		Claims claims = JwtUtil.parseJWT(token);
		if (claims == null) {
			throw new LoginException("请先登录");
		}
		this.putInfoDetailForSession(request,claims.get("userId", Integer.class));
		return true;
	}

	/**
	 * 将登录的用户信息放到session，方便后面获取
	 */
	private void putInfoDetailForSession(HttpServletRequest request, Integer userId) {
		request.getSession().setAttribute("userId", userId);
		request.getSession().setAttribute("userInfo", UserCacheUtil.getUserInfo(userId));
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