package com.java.spring.repository;

import org.springframework.stereotype.Component;

//2. 어노테이션 기반 설정방식
//@Component
public class UserRepositoryImpl implements UserRepository {

	@Override
	public String save(String user) {
		String result = user + " 's data is saved in DB.";
		return result;
	}

}
