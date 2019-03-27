package com.java.spring.repository;

public interface UserRepository {
	// 사용자 정보를 데이터 베이스에 저장한다.
	String save(String user);
}
