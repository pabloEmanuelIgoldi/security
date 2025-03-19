package com.security.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.RequestDTO;
import com.security.dto.ResponseDTO;

import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
@RequestMapping("/v1/test")
@Validated
public class TestController {

	@PostMapping()
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<ResponseDTO> post(@Valid @RequestBody RequestDTO request) {
		log.info("INGRESANDO A AsistenteVirtualController.post(). PREGUNTA: " + request.getAtributo() + ".");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().data("TEST OK : " + request.getAtributo()).build());	
	}

	
}
