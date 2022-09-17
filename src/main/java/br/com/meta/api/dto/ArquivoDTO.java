package br.com.meta.api.dto;

public class ArquivoDTO {

	private String extensao;
	private Integer contagem;
	private Long totalDeLinhas;

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	public Integer getContagem() {
		return contagem;
	}

	public void setContagem(Integer contagem) {
		this.contagem = contagem;
	}

	public Long getTotalDeLinhas() {
		return totalDeLinhas;
	}

	public void setTotalDeLinhas(Long totalDeLinhas) {
		this.totalDeLinhas = totalDeLinhas;
	}
}
