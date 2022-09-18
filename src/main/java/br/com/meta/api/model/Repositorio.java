package br.com.meta.api.model;

import java.io.File;

public class Repositorio {

	private File dirBase;

	public Repositorio(File dirBase) {
		this.dirBase = dirBase;
	}
	
	public File getDirBase() {
		return dirBase;
	}
}
