package br.com.meta.api.repository;

import static br.com.meta.api.utils.ArquivoUtils.criarDiretorio;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.meta.api.model.Arquivo;

@Repository
public class ArquivoRepository {
	
	protected final Logger LOGGER = Logger.getLogger(ArquivoRepository.class);
	private final String BASE_REPOSITORIO_LOCAL = "src/main/resources/repos";
	
	@Autowired
	private GitRepository gitRepository;
	
	public List<Arquivo> buscarArquivo(String usuario, String repositorio) {
		gitRepository.clonar(usuario, repositorio, criarDiretorio(BASE_REPOSITORIO_LOCAL, repositorio));
		return lerTodosDiretorios();
	}	
	
	private List<Arquivo> lerTodosDiretorios() {
		List<Arquivo> arquivos = new ArrayList<>();
		for(int i = 0; i < 48; i++) {
			arquivos.add(new Arquivo());
		}
		return arquivos;
	}
}
