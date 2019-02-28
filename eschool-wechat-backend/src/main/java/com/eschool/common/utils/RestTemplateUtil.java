package com.eschool.common.utils;

import org.springframework.http.HttpHeaders;

public class RestTemplateUtil {
	static HttpHeaders jsonHeaders;
	static {
		jsonHeaders = new HttpHeaders();
		jsonHeaders.add("Content-Type", "application/json;charset=UTF-8");
	}
	
	
}
