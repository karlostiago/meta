package br.com.meta.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.meta.api.service.ArquivoService;
import br.com.meta.api.service.impl.ArquivoServiceImpl;
import br.com.meta.api.service.impl.FakeArquivoServiceImpl;

@Configuration
public class RepositorioLocalConfig {
	
	@Autowired
	private RepositorioLocalProperties repositorioLocalProperties;
	
	@Bean
	public ArquivoService arquivoService() {
		switch (repositorioLocalProperties.getImplementacao()) {
		case FAKE:
			return new FakeArquivoServiceImpl();
		case LOCAL:
			return new ArquivoServiceImpl();
		default:
			return null;
		}
	}
}
