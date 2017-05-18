package com.www.opeartor.interapor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FristInterapor extends HandlerInterceptorAdapter{

	private static Logger logger = LogManager.getLogger(FristInterapor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String httpUrl = request.getServletPath();
		logger.info("请求httpurl:{}",httpUrl);
		return  true;
		
	}
	
	

}
