package org.Isaveu.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/loginPost");
//		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**/*").excludePathPatterns("/admin/**", "/Android/**", "/module/**", "/css/**", "/img/**", "/js/**", "/user/**" ,"/mobile/**","/test/**");
//		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/admin/**");
	}
	
}
		
		
