package com.java.spring.encoder;

public interface PasswordEncoder {
	// 패스워드를 해시 한다.
	String encode(String rawPassword);
}
