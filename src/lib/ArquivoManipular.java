package lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ArquivoManipular { 

	public static final boolean escreverArquivoSerializado(List<?> listaObjeto, String nomeArquivo) {
		ObjectOutputStream arquivo = null;
		
	    try {
	    	arquivo =  new ObjectOutputStream(new FileOutputStream(nomeArquivo));
	    	arquivo.writeObject(listaObjeto);

	    } catch (IOException e) {

			return false;
	    } finally {
	    	try {
	    		if (arquivo != null) arquivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    return true;
	}
	
	public static final List<?> lerArquivoSerializado(String nomeArquivo) {

        List<?> listaObjeto;
        ObjectInputStream arquivo = null;
		
		try {
	       
			arquivo = new ObjectInputStream(new FileInputStream(nomeArquivo));
	        listaObjeto = (List<?>) arquivo.readObject();

		 } catch (IOException|ClassNotFoundException e) {
			
			 return null;
		 } finally {
			 try {
				 if (arquivo != null) arquivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 return listaObjeto;
		 
	}
	
}
