package com.sw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class BeanConfig {

	  /**
	   * 注意是org.springframework.security.crypto.password.PasswordEncoder
     * @Description: 密码的加密解密
     * @param @return
     * @return PasswordEncoder
     * @throws
     * @author lihaoyang
     * @date 2018年3月12日
     */
    @Bean
    public PasswordEncoder passwordencoder(){
        //BCryptPasswordEncoder implements PasswordEncoder
        return new BCryptPasswordEncoder();
    }
}
