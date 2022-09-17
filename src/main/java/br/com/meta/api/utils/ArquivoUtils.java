package br.com.meta.api.utils;

import java.io.File;

public class ArquivoUtils {
	
	public static File criarDiretorio(String diretorioPai, String diretorioFilho) {
		File arquivo = new File(diretorioPai, diretorioFilho);
		arquivo.mkdir();
		return arquivo;
	}
}
