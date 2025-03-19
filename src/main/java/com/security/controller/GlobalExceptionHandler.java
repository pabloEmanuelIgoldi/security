package com.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.security.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handleException(Exception e) {
		log.error("GlobalExceptionHandler.handleException(): " + e);
		return new ResponseEntity<>(ResponseDTO.builder().messageError("ERROR GENERAL.").hasError(Boolean.TRUE).build(), 
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ResponseDTO> handleUsernameNotFoundException(UsernameNotFoundException e) {
		log.error("GlobalExceptionHandler.handleException(): " + e);
		return new ResponseEntity<>(ResponseDTO.builder().messageError("USUARIO INEXISTENTE.").hasError(Boolean.TRUE).build(), 
				HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ResponseDTO> handleBadCredentialsException(BadCredentialsException e) {
		log.error("GlobalExceptionHandler.handleException(): " + e);
		return new ResponseEntity<>(ResponseDTO.builder().messageError("CREDENCIALES ERRONEAS.").hasError(Boolean.TRUE).build(), 
				HttpStatus.UNAUTHORIZED);
	}
	

	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ResponseDTO> handleAccessDeniedException(AccessDeniedException e) {
		log.error("GlobalExceptionHandler.handleAccessDeniedException(): " + e.getMessage());
		return new ResponseEntity<>(ResponseDTO.builder().messageError("RECURSO NO AUTORIZADO PARA EL USUARIO.").hasError(Boolean.TRUE).build(), 
				HttpStatus.FORBIDDEN);
	}
}