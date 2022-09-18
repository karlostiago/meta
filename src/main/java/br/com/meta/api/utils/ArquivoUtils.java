package br.com.meta.api.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.apache.commons.io.FilenameUtils;

public class ArquivoUtils {
	
	public static File criarDiretorio(String diretorioPai, String diretorioFilho) {
		File arquivo = new File(diretorioPai, diretorioFilho);
		arquivo.mkdir();
		return arquivo;
	}
	
	public static int getNumeroLinhas(File arquivo) {
		try (LineNumberReader lnr = new LineNumberReader(new FileReader(arquivo))) {
			lnr.skip(Long.MAX_VALUE);
			return lnr.getLineNumber();
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String getExtensao(String nomeArquivo) {
		return FilenameUtils.getExtension(nomeArquivo);
	}
}
