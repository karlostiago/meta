package br.com.meta.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class GitCloneException extends RuntimeException {

	private static final long serialVersionUID = 4903121675710798326L;
	
	public GitCloneException() {
		super("Repositorio já existe.");
	}
}
