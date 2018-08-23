package util;

import java.io.File;

public class Util {
	
	private static final String DIRETORIO_DADOS = "\\Dados\\";
	
	public static String getDiretorio(){
        return System.getProperty("user.dir");
    }
	
	public static String getDiretorioDados(){
		String diretorio = new StringBuilder().append(getDiretorio()).append(DIRETORIO_DADOS).toString();
        verificarDiretorio(diretorio);
        return diretorio;
    }
	
	private static void verificarDiretorio(String caminhoDiretorio){
        File diretorio = new File(caminhoDiretorio);
        if (!diretorio.exists()) diretorio.mkdir();
    }
}
