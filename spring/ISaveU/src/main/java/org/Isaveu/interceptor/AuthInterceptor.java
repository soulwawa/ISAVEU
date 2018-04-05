package org.Isaveu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.Isaveu.domain.TbHrVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements HandlerInterceptor{
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object tbHrVO = modelMap.get("tbHrVO");
		
		if( tbHrVO != null) {
			logger.info("WEB LOGIN SUCCSS");
			session.setAttribute(LOGIN, tbHrVO);
			response.sendRedirect("/");
		}
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		TbHrVO loginVO = (TbHrVO) session.getAttribute("login");
		
		if(ObjectUtils.isEmpty(loginVO)) {
			response.sendRedirect("/");
			return false;
		}else {
			session.setMaxInactiveInterval(30*60);
			return true;
		}
	}
}
