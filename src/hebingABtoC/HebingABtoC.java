package hebingABtoC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 编写一个程序， 将 a.txt  文件中的单词与 b.txt  文件中的单词交替合并到 c.txt
 * 文件中， 文件中， a.txt ， 文件中的单词用回车符分隔， b.txt 。
 * @author tree
 *
 */
public class HebingABtoC {
	public static void main(String[] args) throws Exception{
		FileManager a = new FileManager("resources/a.txt",new char[]{'\n'});
		FileManager b = new FileManager("resources/b.txt",new char[]{'\n',' '});
		File file = new File("resources/c.txt");
		FileWriter c = new FileWriter(file);
		String aWord = null;
		String bWord = null;
		while((aWord=a.nextWords())!=null){
			c.write(aWord+"\n");
			bWord=b.nextWords();
			if(bWord!=null){
				c.write(bWord+"\n");
			}
		}
		while((bWord=b.nextWords())!=null){
			c.write(bWord+"\n");
		}
		c.close();
	}
}
