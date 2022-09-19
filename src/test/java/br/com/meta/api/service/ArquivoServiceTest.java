package br.com.meta.api.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.meta.api.abstracts.AbstractRunApplicationTest;
import br.com.meta.api.exception.RepositorioNaoExisteException;
import br.com.meta.api.model.Arquivo;

public class ArquivoServiceTest extends AbstractRunApplicationTest {
	
	@Autowired
	private ArquivoService arquivoService;
	
	@Test
	public void deveBuscarTodosArquivoNoDiretorioBase() {
		List<Arquivo> arquivos = arquivoService.buscarArquivos("karlostiago", "algamoney-api");
		
		Assertions.assertThat(arquivos.size())
			.isEqualTo(57);
	}	
	
	@Test(expected = RepositorioNaoExisteException.class)
	public void deveOcorrerUmaExceptionQuandoRepositorioNaoExistir() {
		arquivoService.buscarArquivos("karlostiago", "algamoney");
	}	
}
