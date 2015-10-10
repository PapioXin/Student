package subString;

/**
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截 取的字符串，
 * 但要保证汉字不被截取半个，如“我 ABC”，4，应该截取“我 AB”， 
 * 输入“我 ABC 汉 DEF”，6，应该输出“我 ABC”，而不是“我 ABC+汉的半个”。 
 * @author Papio
 *
 */
public class SubString {
	public static void main(String[] args) throws Exception{
		String str = "我是你apio我非常nice喜欢abc";
		int num = trimGBK(str.getBytes("GBK"),5);
		System.out.println(str.substring(0,num));
	}

	private static int trimGBK(byte[] bytes, int i) {
		int a = 0;
		boolean b = false;
		for(int j = 0;j<i;j++){
			if(bytes[j]<0&&!b){
				b = true;
			}else{
				a++;
				b=false;
			}
		}
		return a;
	}
}
