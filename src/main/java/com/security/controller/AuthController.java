package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.RequestAuthDTO;
import com.security.dto.ResponseTokenDTO;
import com.security.model.Usuario;
import com.security.service.IAuthService;


@RequestMapping("/v1/auth")
@RestController
public class AuthController {
    @Autowired
    private IAuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<ResponseTokenDTO> login(@RequestBody RequestAuthDTO authDTO) {
        String token = authService.buildToken(Usuario.builder().username(authDTO.getUsername()).password(authDTO.getPassword()).build());
        return ResponseEntity.status(HttpStatus.OK).body(ResponseTokenDTO.builder().data(token).build());
    }

}
