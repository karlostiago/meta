package br.com.meta.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meta.api.model.Arquivo;
import br.com.meta.api.repository.ArquivoRepository;

@Service
public class ArquivoService {
	
	@Autowired
	private ArquivoRepository arquivoRepository;
	
	public List<Arquivo> buscarArquivos(String usuario, String repositorio) {
		return arquivoRepository.buscarArquivo(usuario, repositorio);
	}
}
