package br.com.meta.api.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.meta.api.exception.RepositorioNaoExisteException;
import br.com.meta.api.io.ArquivoReader;
import br.com.meta.api.model.Arquivo;
import br.com.meta.api.service.ArquivoService;

public class FakeArquivoServiceImpl implements ArquivoService  {
	
	@Autowired
	private ArquivoReader arquivoReader;
	
	@Override
	public List<Arquivo> buscarArquivos(String usuario, String nomeRepositorio) {
		File repositorio = new File("src/test/resources/repos", nomeRepositorio); 
		
		if (!repositorio.exists()) {
			throw new RepositorioNaoExisteException();
		}
		
		List<Arquivo> arquivos = arquivoReader.lerDiretorio(repositorio, new ArrayList<>());
		return arquivos;
	}
}
