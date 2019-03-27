package com.java.spring.encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

//2. 어노테이션 기반 설정 방식
//@Component
public class SHA256Encoder implements PasswordEncoder{

	// SHA256 방식으로 encode 해주는 코드
	@Override
	public String encode(String rawPassword) {
		String sha = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(rawPassword.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<byteData.length; i++) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			sha = sb.toString();
		}
		catch(NoSuchAlgorithmException e) {
			System.out.println("Encrypt Error - NoSuchAlgorithmException");
			sha = null;
		}
		return sha;
	}

}
