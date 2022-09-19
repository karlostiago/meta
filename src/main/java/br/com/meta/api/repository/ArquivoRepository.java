package br.com.meta.api.repository;

import static br.com.meta.api.utils.ArquivoUtils.criarDiretorio;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import br.com.meta.api.exception.RepositorioNaoExisteException;
import br.com.meta.api.model.Repositorio;

@Repository
public class ArquivoRepository {
	
	protected final Logger LOGGER = Logger.getLogger(ArquivoRepository.class);
	
	@Value("${meta.repositorio-local}")
	private String BASE_REPOSITORIO_LOCAL;
	
	@Autowired
	private GitRepository gitRepository;
	
	public Repositorio buscarRepositorio(String usuario, String repositorio) {
		if (naoExisteRepositorio(repositorio)) {			
			clonarRepositorio(usuario, repositorio);
		}

		File [] arquivos = new File(BASE_REPOSITORIO_LOCAL).listFiles();
		for (File dir : arquivos) {
			if (dir.isDirectory() && repositorio.equalsIgnoreCase(dir.getName())) {
				return new Repositorio(dir);
			}
		}
		
		throw new RepositorioNaoExisteException();
	}
	
	private void clonarRepositorio(String usuario, String repositorio) {		
		String repositorioURL = gitRepository.buscarRepositorio(usuario, repositorio);
		gitRepository.clonar(repositorioURL, criarDiretorio(BASE_REPOSITORIO_LOCAL, repositorio));
	}
	
	private Boolean existeRepositorio(String nomeRepositorio) {
		List<File> arquivos = Arrays.asList(new File(BASE_REPOSITORIO_LOCAL).listFiles())
				.stream()
				.filter(arquivo -> arquivo.getName().equalsIgnoreCase(nomeRepositorio))
				.collect(Collectors.toList());
		
		return !arquivos.isEmpty() ? true : false;
	}
	
	private Boolean naoExisteRepositorio(String nomeRepositorio) {
		return !existeRepositorio(nomeRepositorio);
	}
}
