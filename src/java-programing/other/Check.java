//统计代码的总行数、空行数、注释行数、非注释行数
import java.io.*;

public class Check {
	public static void main(String[] args) throws IOException{
		//被统计的代码的所在的路径
		check("E://Workspace//Eclipse-workspace//Online_Programming//src//other//Test1.java");
	}

	public static void check(String s) throws IOException {
		int all = 0,empty = 0,describe = -1,i = 0;
		String str = null;
		File f = new File(s);
		BufferedReader br = new BufferedReader(new FileReader(f));
		str = br.readLine();
		while(str != null){
			all++;
			if (str.trim().equals("")) {
				empty++;
			}
			if (str.contains("//")) {
				describe++;
			}
			if(str.contains("/*")) {
				while(!str.contains("*/")){
					i++;
					all++;
					describe++;
					str = br.readLine();
				}
			}
			str = br.readLine();
		}
		System.out.println("中文物理总行数为："+ all);
		System.out.println("文件中空行数为：" + empty);
		System.out.println("文件注释行数为：" + describe);
		System.out.println("文件非注释行数为：" + (all-i));
	}
}
