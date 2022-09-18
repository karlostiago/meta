package br.com.meta.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meta.api.assembler.ArquivoAssembler;
import br.com.meta.api.dto.ArquivoDTO;
import br.com.meta.api.model.Arquivo;
import br.com.meta.api.service.ArquivoService;

@RestController
@RequestMapping(path = "/v1/arquivos")
public class ArquivoController {
	
	@Autowired
	private ArquivoService arquivoService;
	
	@Autowired
	private ArquivoAssembler arquivoAssembler;
	
	@GetMapping("/{usuario}/{repositorio}")
	public List<ArquivoDTO> arquivos(@PathVariable String usuario, @PathVariable String repositorio) {
		List<Arquivo> arquivos = arquivoService.buscarArquivos(usuario, repositorio);
		return arquivoAssembler.paraArquivo(arquivos);
	}
}
