package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
		
	private BufferedReader file;
	
	public boolean readFile(String path, String fileName) {
        
        if (!(new File(path + fileName).isFile())) return false;
                
        try {
        		
    		FileReader fileReader = new FileReader(path + fileName);
    		file = new BufferedReader(fileReader);
    		
        } catch (IOException e) {
        	return false;
        }
         
		return true;
        
    }  
	
	public boolean hasNext() {
		try {
			return file.ready();
		} catch (IOException e) {
		}	
		return false;
	}
	
	public String next() {

        try {
			return file.readLine();
		} catch (IOException e) {
			close();
		}
        
        return "";
	}
	
	public void close() {
		try {
			file.close();
		} catch (IOException e1) {
		}
	}
	
}