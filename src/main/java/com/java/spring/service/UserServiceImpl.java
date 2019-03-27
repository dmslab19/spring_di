package com.java.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.spring.encoder.PasswordEncoder;
import com.java.spring.repository.UserRepository;

//2. 어노테이션 기반 설정 방식
//@Component
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	//@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public UserServiceImpl() {
		
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void register(String user, String rawPassword) {
		
		String encodedPassword = passwordEncoder.encode(rawPassword);
		String saveResult = userRepository.save(user);
		System.out.println(user + " is registered. [Encrypted password: " + encodedPassword +"]");
		System.out.println(saveResult);
	}
	
}
