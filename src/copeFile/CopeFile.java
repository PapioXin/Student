package copeFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * 编写一个程序，将 d:\java  目录下的所有.java  文件复制到 d:\jad 目录下，并 目录下，并
 * 将原来文件的扩展名从 将原来文件的扩展名从.java  改为.jad
 * @author tree
 *
 */
public class CopeFile {
	public static void main(String[] args) throws Exception {
		File filejava = new File("D://java");
		if (!filejava.exists() && !filejava.isDirectory()) {
			throw new Exception("java文件夹不存在");
		}
		File[] files = filejava.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		File filejad = new File("d://jad");
		if (!(filejava.exists() || filejava.isDirectory())) {
			throw new Exception("jad文件夹不存在");
		}
		for(File f : files){
			FileInputStream inputStream = new FileInputStream(f);
			String filename = f.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream outputStream = new FileOutputStream(new File(filejad,filename));
			copy(inputStream,outputStream);
			inputStream.close();
			outputStream.close();
		}
	}

	private static void copy(FileInputStream inputStream,
			FileOutputStream outputStream) throws IOException {
		int len = 0;
		byte[] buf = new byte[1024];
		while((len=inputStream.read(buf))!=-1){
			outputStream.write(buf,0,len);
		}
	}
}
