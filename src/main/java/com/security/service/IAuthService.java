package com.security.service;

import com.security.model.Usuario;

public interface IAuthService {
	
	String buildToken(Usuario user);

}
