package br.com.meta.api.repository;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.meta.api.model.Autor;

@Repository
public class GitRepository {
	
	protected final Logger LOGGER = Logger.getLogger(GitRepository.class);
	private final String BASE_GITHUB_API = "https://api.github.com/repos/%s/%s";
	
	public void clonar(String usuario, String repositorio, File diretorio) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Autor> response = rt.getForEntity(String.format(BASE_GITHUB_API, usuario, repositorio), Autor.class);
		String url = response.getBody().getHtml_url().concat(".git");
		
		try {
			Git.cloneRepository()
				.setURI(url)
				.setDirectory(diretorio)
				.call();
		} catch (GitAPIException e) {
			LOGGER.error(e);
		}
	}
}
