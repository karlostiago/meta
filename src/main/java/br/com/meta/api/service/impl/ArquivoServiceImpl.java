package br.com.meta.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meta.api.io.ArquivoReader;
import br.com.meta.api.model.Arquivo;
import br.com.meta.api.model.Repositorio;
import br.com.meta.api.repository.ArquivoRepository;
import br.com.meta.api.service.ArquivoService;

@Service
public class ArquivoServiceImpl implements ArquivoService {
	
	@Autowired
	private ArquivoRepository arquivoRepository;
	
	@Autowired
	private ArquivoReader arquivoReader;
	
	@Override
	public List<Arquivo> buscarArquivos(String usuario, String nomeRepositorio) {
		Repositorio repositorio = arquivoRepository.buscarRepositorio(usuario, nomeRepositorio);
		List<Arquivo> arquivos = arquivoReader.lerDiretorio(repositorio.getDirBase(), new ArrayList<>());
		return arquivos;
	}
}
