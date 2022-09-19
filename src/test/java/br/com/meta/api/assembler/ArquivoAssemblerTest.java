package br.com.meta.api.assembler;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.meta.api.abstracts.AbstractRunApplicationTest;
import br.com.meta.api.exception.RepositorioNaoExisteException;
import br.com.meta.api.model.Arquivo;
import br.com.meta.api.model.dto.ArquivoDTO;
import br.com.meta.api.service.ArquivoService;

public class ArquivoAssemblerTest extends AbstractRunApplicationTest {
	
	@Autowired
	private ArquivoService arquivoService;
	
	@Autowired
	private ArquivoAssembler arquivoAssembler;
	
	private List<Arquivo> arquivos;
	
	@Before
	public void setup() {
		arquivos = arquivoService.buscarArquivos("karlostiago", "algamoney-api");
	}
	
	@Test
	public void deveConstruirListaDeArquivosQuandoRepositorioExistirLocal() {
		List<ArquivoDTO> arquivosDTO = arquivoAssembler.paraArquivo(arquivos);
		
		Assertions.assertThat(arquivosDTO.size())
			.isEqualTo(3);
	}
	
	@Test(expected = RepositorioNaoExisteException.class)
	public void naoDeveConstruirListaDeArquivosQuandoNaoExistirRepositorioLocal() {
		arquivoService.buscarArquivos("karlostiago", "algamoney");
	}
}
