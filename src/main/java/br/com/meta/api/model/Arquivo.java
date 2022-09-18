package br.com.meta.api.model;

import java.util.Objects;

public class Arquivo {

	private String nome;
	private String extensao;
	private int numeroDeLinhas;

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

	public int getNumeroDeLinhas() {
		return numeroDeLinhas;
	}

	public void setNumeroDeLinhas(int numeroDeLinhas) {
		this.numeroDeLinhas = numeroDeLinhas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
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
		return Objects.equals(nome, other.nome);
	}
}
