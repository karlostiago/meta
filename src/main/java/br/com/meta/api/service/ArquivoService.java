package br.com.meta.api.service;

import java.util.List;

import br.com.meta.api.model.Arquivo;

public interface ArquivoService {
	
	public List<Arquivo> buscarArquivos(String usuario, String nomeRepositorio);
}
