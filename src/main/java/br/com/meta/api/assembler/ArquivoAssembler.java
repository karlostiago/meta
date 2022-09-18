package br.com.meta.api.assembler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.com.meta.api.dto.ArquivoDTO;
import br.com.meta.api.model.Arquivo;

@Component
public class ArquivoAssembler {
	
	public List<ArquivoDTO> paraArquivo(List<Arquivo> arquivos) {
		Map<String, List<Arquivo>> arquivosAgrupados = agrupar(arquivos);
		List<ArquivoDTO> arquivosDTO = new ArrayList<>();
		
		for (Map.Entry<String, List<Arquivo>> entry : arquivosAgrupados.entrySet()) {
			List<Arquivo> arquivosSelecionados = entry.getValue();
			
			ArquivoDTO arquivoDTO = new ArquivoDTO();
			arquivoDTO.setExtensao(arquivosSelecionados.get(0).getExtensao());
			arquivoDTO.setContagem(arquivosSelecionados.size());
			arquivoDTO.setTotalDeLinhas(
				arquivosSelecionados.stream().mapToLong(arquivoSelecionado -> arquivoSelecionado.getNumeroDeLinhas()).sum()
			);
			
			arquivosDTO.add(arquivoDTO);
		}
		
		return arquivosDTO;
	}
	
	private Map<String, List<Arquivo>> agrupar(List<Arquivo> arquivos) {
		Map<String, List<Arquivo>> agruparArquivos = new HashMap<>();
		
		for (Arquivo arquivo : arquivos) {
			List<Arquivo> arquivosAgrupados = agruparArquivos.get(arquivo.getExtensao());
			if (arquivosAgrupados == null) {
				agruparArquivos.put(arquivo.getExtensao(), arquivosAgrupados = new ArrayList<>());
			}
			arquivosAgrupados.add(arquivo);
		}
		
		return agruparArquivos;
	}
}
