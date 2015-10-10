package hebingABtoC;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
	
	private int pos=0;
	private String[] words=null;
	
	public FileManager(String fileName,char[] condition) throws IOException{
		File file = new File(fileName);
		FileReader reader = new FileReader(file);
		char[] buff = new char[(int)file.length()];
		int len = reader.read(buff);
		String results = new String(buff,0,len);
		String regex=null;
		if(condition.length>1){
			regex=""+condition[0]+"|"+condition[1];
		}else{
			regex=""+condition[0];
		}
		words=results.split(regex);
	}
	
	public String nextWords(){
		if(pos==words.length){
			return null;
		}else{
			return words[pos++];
		}
	}
}
