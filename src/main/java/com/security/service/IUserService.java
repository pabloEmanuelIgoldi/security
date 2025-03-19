package com.security.service;

import com.security.model.Usuario;

public interface IUserService {

	public Usuario findUserByUsername(String username);
}
