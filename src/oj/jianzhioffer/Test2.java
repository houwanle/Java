package test;
/* 替换空格
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Test2 {
	public static void main(String[] args){
		StringBuffer str = new StringBuffer("We are happy");
		System.out.println(replaceSpace(str));
	}

	public static String replaceSpace(StringBuffer str) {
		if(str == null)
			return null;
		StringBuffer sBuffer = new StringBuffer();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i)== ' '){
				sBuffer.append('%');
				sBuffer.append('2');
				sBuffer.append('0');
			}else{
				sBuffer.append(str.charAt(i));
			}
		}
		return sBuffer.toString();
	}
}