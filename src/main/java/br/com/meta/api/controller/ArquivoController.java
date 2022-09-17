package br.com.meta.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meta.api.dto.ArquivoDTO;
import br.com.meta.api.service.ArquivoService;

@RestController
@RequestMapping(path = "/v1/arquivos")
public class ArquivoController {
	
	@Autowired
	private ArquivoService arquivoService;
	
	@GetMapping("/{usuario}/{repositorio}")
	public List<ArquivoDTO> arquivos(@PathVariable String usuario, @PathVariable String repositorio) {
		arquivoService.buscarArquivos(usuario, repositorio);
		return new ArrayList<ArquivoDTO>();
	}
}
