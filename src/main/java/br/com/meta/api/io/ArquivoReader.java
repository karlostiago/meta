package br.com.meta.api.io;

import static br.com.meta.api.utils.ArquivoUtils.getExtensao;
import static br.com.meta.api.utils.ArquivoUtils.getNumeroLinhas;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.meta.api.exception.ArquivoNaoExisteException;
import br.com.meta.api.model.Arquivo;

@Component
public class ArquivoReader {
	
	private static final List<String> IGNORAR = Arrays.asList(".git", ".gitignore", ".mvn", "mvnw", "mvnw.cmd", "Procfile");
	
	public List<Arquivo> lerDiretorio(File repositorio, List<Arquivo> arquivos) {
		
		if (arquivos == null || arquivos.isEmpty()) {
			throw new ArquivoNaoExisteException();
		}
		
		for (File file : repositorio.listFiles()) {
			
			if(IGNORAR.contains(file.getName())) {
				continue;
			}

			if (!file.isDirectory()) {
				Arquivo arquivo = new Arquivo();
				arquivo.setNome(file.getName());
				arquivo.setExtensao(getExtensao(arquivo.getNome()));
				arquivo.setNumeroDeLinhas(getNumeroLinhas(file));
				arquivos.add(arquivo);
			}
			else {
				lerDiretorio(file, arquivos);
			}
		}
		
		return arquivos;
	}
}
