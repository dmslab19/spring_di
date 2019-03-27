package com.java.spring.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.config.AppConfig;
import com.java.spring.service.UserService;

public class ExampleApplication {

	public static void main(String[] args) {
		
		// 세가지의 방법 중 '하나'의 방식으로 context를 얻는다
		// 1. 자바 기반의 설정 방식
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// 2. 어노테이션 기반의 설정 방식
		//ApplicationContext context = new AnnotationConfigApplicationContext("com.java.spring");
		// 3. XML 기반의 설정 방식
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// context에서 DI가 완료된 컴포넌트를 얻어낸다.
		UserService userService = context.getBean(UserService.class);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input User name: ");
		String userId = scanner.next();
		System.out.print("Input User password: ");
		String userPw = scanner.next();
		userService.register(userId, userPw);
	}

}
