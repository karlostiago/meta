package br.com.meta.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RepositorioNaoExisteException extends RuntimeException {
	
	private static final long serialVersionUID = -7031703501220325132L;

	public RepositorioNaoExisteException() {
		super("Repositório não existe.");
	}
}
