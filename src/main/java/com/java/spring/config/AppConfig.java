package com.java.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.java.spring.encoder.PasswordEncoder;
import com.java.spring.encoder.SHA256Encoder;
import com.java.spring.repository.UserRepository;
import com.java.spring.repository.UserRepositoryImpl;
import com.java.spring.service.UserService;
import com.java.spring.service.UserServiceImpl;

//1. 자바 기반 설정 방식
@Configuration
@ComponentScan("com.java.spring")
public class AppConfig {
	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new SHA256Encoder();
	}
	
	// 생성자 기반의 의존성 주입
	@Bean
	UserService userService() {
		return new UserServiceImpl(userRepository(), passwordEncoder());
	}
	
	// setter 기반의 의존성 주입
//	@Bean
//	UserService userService() {
//		UserServiceImpl userService = new UserServiceImpl();
//		userService.setUserRepository(userRepository());
//		userService.setPasswordEncoder(passwordEncoder());
//		return userService;
//	}
}
