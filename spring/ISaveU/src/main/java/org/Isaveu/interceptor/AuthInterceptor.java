package org.Isaveu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.Isaveu.domain.TbHrVO;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor{

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
