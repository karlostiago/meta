package br.com.meta.api.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.meta.api.exception.ArquivoNaoExisteException;
import br.com.meta.api.exception.GitCloneException;
import br.com.meta.api.exception.RepositorioNaoExisteException;

@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RepositorioNaoExisteException.class)
	public ResponseEntity<?> handleRepositorioNaoExisteException(RepositorioNaoExisteException e, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Error error = new Error();
		error.setMensagem(e.getMessage());
		error.setStatus(status.value());
		error.setTipoErro(TipoErro.BAD_REQUEST);
		
		return handleExceptionInternal(e, error, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(ArquivoNaoExisteException.class)
	public ResponseEntity<?> handleArquivoNaoExisteException(ArquivoNaoExisteException e, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Error error = new Error();
		error.setMensagem(e.getMessage());
		error.setStatus(status.value());
		error.setTipoErro(TipoErro.BAD_REQUEST);
		
		return handleExceptionInternal(e, error, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(GitCloneException.class)
	public ResponseEntity<?> handleGitCloneException(GitCloneException e, WebRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		
		Error error = new Error();
		error.setMensagem(e.getMessage());
		error.setStatus(status.value());
		error.setTipoErro(TipoErro.CONFLICT);
		
		return handleExceptionInternal(e, error, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException e, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		Error error = new Error();
		error.setMensagem(e.getMessage());
		error.setStatus(status.value());
		error.setTipoErro(TipoErro.NOT_FOUND);
		
		return handleExceptionInternal(e, error, headers, status, request);
	}
}
