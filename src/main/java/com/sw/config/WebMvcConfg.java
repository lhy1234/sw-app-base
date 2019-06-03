package com.sw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sw.interceptor.LoginHandlerInterceptor;
import com.sw.interceptor.SignHandlerInterceptor;

@Configuration
public class WebMvcConfg extends WebMvcConfigurerAdapter {
	
	@Bean
	public SignHandlerInterceptor signHandlerInterceptor() {
		return new SignHandlerInterceptor();
	}
	
	@Bean
	public LoginHandlerInterceptor loginHandlerInterceptor() {
		return new LoginHandlerInterceptor();
	}

	
	/**
	 *    一个星号 /* 表示任意字符
	 *    两个星号 /** 表示任意层次的任意字符
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(signHandlerInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/",
						"/sw/app/users/login/account",//用户名密码登录
						"/sw/app/users/login/code",   //短信验证码登录
						"/hello",                     //测试
						"/sw/app/users/register",     //用户注册
						"/sw/app/code/sms/send"       //发送短信验证码
						
						
						
						);
		//registry.addInterceptor(loginHandlerInterceptor())
				//.addPathPatterns("/**")
				//.excludePathPatterns("/user/login/account");
	} 
	
	

}
