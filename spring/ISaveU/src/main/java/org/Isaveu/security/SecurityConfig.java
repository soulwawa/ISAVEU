package org.Isaveu.security;

import org.Isaveu.interceptor.AuthInterceptor;
import org.Isaveu.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/loginPost");
		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**/*").excludePathPatterns("/admin/**", "/android/**", "/module/**", "/css/**", "/img/**", "/js/**");
	}
	
}
		
		
