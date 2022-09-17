package br.com.meta.api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/arquivos", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ArquivoController {
	
	public ResponseEntity<?> teste() {
		return null;
	}
}
