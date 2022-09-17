package br.com.meta.api.model;

import java.util.Objects;

public class Arquivo {

	private Long codigo;
	private String nome;
	private String extensao;
	private Long totalDeLinhas;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public Long getTotalDeLinhas() {
		return totalDeLinhas;
	}

	public void setTotalDeLinhas(Long totalDeLinhas) {
		this.totalDeLinhas = totalDeLinhas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arquivo other = (Arquivo) obj;
		return Objects.equals(codigo, other.codigo);
	}
}
