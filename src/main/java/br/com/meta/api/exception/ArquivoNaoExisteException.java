package br.com.meta.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ArquivoNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = -5507945593796995124L;
	
	public ArquivoNaoExisteException() {
		super("Nenhum arquivo encontrado no repositorio.");
	}
}
