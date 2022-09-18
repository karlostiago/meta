package br.com.meta.api.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Error {
	
	private int status;
	private String mensagem;
	private TipoErro tipoErro;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public TipoErro getTipoErro() {
		return tipoErro;
	}

	public void setTipoErro(TipoErro tipoErro) {
		this.tipoErro = tipoErro;
	}
}
