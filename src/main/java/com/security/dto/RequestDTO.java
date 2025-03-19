package com.security.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

public class RequestDTO {

	@NotBlank
	@Getter	
	private String atributo;
}