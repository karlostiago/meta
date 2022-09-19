package br.com.meta.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("meta")
public class RepositorioLocalProperties {
	
	private String repositorioLocal;
	
	private Implementacao implementacao = Implementacao.FAKE;
	
	public enum Implementacao {
		FAKE, LOCAL
	}
	
	public Implementacao getImplementacao() {
		return implementacao;
	}

	public void setImplementacao(Implementacao implementacao) {
		this.implementacao = implementacao;
	}

	public String getRepositorioLocal() {
		return repositorioLocal;
	}

	public void setRepositorioLocal(String repositorioLocal) {
		this.repositorioLocal = repositorioLocal;
	}
}
