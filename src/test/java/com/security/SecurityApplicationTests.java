package com.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.security.model.Usuario;
import com.security.service.IAuthService;

@SpringBootTest
class SecurityApplicationTests {
	
	@Autowired
	private IAuthService authService;

	@Test
	void buildTokenTest() {
		Usuario user = Usuario.builder().username("pablo").password("1234").build();
		String token = authService.buildToken(user);
		System.out.print(token);
	}

}
