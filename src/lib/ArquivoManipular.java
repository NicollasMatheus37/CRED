package lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ArquivoManipular { 

	public static final boolean escreverArquivoSerializado(List<?> listaObjeto, String nomeArquivo) {
		
	    try {
	        new ObjectOutputStream(new FileOutputStream(nomeArquivo)).writeObject(listaObjeto);

	    } catch (IOException e) {

			return false;
	    }
	    
	    
	    return true;
	}
	
	public static final List<?> lerArquivoSerializado(String nomeArquivo) {

        List<?> listaObjeto;
		
		try {
	       
	        listaObjeto = (List<?>) new ObjectInputStream(new FileInputStream(nomeArquivo)).readObject();

		 } catch (IOException|ClassNotFoundException e) {
			
			 return null;
		 }
		 
		 return listaObjeto;
		 
	}
	
}
