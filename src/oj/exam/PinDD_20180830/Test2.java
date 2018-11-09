package PinDD_20180830;
/*题目描述
    有个长方形的棋盘，每个格子可能是以下三种情况，
    A放有障碍物，不可移动；B放置着小木块，C格子为空。
    如果把棋盘竖起来，小木块会向下掉落，直至落到障碍物上
    或者落到障碍物上叠加着的小木块上。如果底部没有障碍物时，
    则会掉出棋盘。
    请问棋盘的最终状态。

    输入描述：
    第一行包含2个正整数N、M(1<=N,M<=10),分别表示棋盘的高度以及宽度。
    接下来N*M的矩阵表示了棋盘从上到下的状态。
    接下来有N行，每行是一个长度为M的字符串，字符串仅包含：'x'表示障碍物
    ，'o'表示小木块，'.'表示空格子。
    输出描述：
    输出N行，每行M个字符，表示最终棋盘的状态。

    示例
    输入
    3 4
    .oxo
    o..o
    .xox
    输出
    ..xo
    .o.o
    .x.x

 */

import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int m = Integer.parseInt(str.split(" ")[1]);
        String[] qipans = new String[n];
        for(int i=0;i<n;i++) {
            qipans[i] = in.nextLine();
        }
        char[][] qipan = new char[n][m];
        for(int i=0;i<n;i++) {
            qipan[i] = qipans[i].toCharArray();
        }
        char[] temp = new char[n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                temp[j] = qipan[j][i];
            }
            temp =  get_result(temp);
            for(int j=0;j<n;j++) {
                qipan[j][i] = temp[j];
            }

        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(qipan[i][j]);
            }
            System.out.println();

        }
    }

    public static char[] get_result(char[] line) {
        String string = String.valueOf(line);
        char[] result = new char[line.length];
        if(!string.contains("x")) {
            for(int i=0;i<line.length;i++) {
                result[i] = '.';
            }
            return result;
        }else {
            int cnt = 0;
            boolean flag = true;
            for(int i=line.length-1;i>=0;i--) {
                if(line[i] == 'x') {
                    result[i] = 'x';
                    cnt = 0;
                    flag = false;
                }else {
                    if(flag) {
                        result[i] = '.';
                        continue;
                    }
                    if(i == line.length-1) {
                        result[i] = '.';
                        continue;
                    }
                    if(result[i+1] == '.') {
                        if(line[i] == 'o') {
                            if(cnt==0) {
                                result[i] = '.';
                                continue;
                            }
                            result[i] = result[i+cnt];
                            result[i+cnt] = line[i];
                        }else {
                            cnt = cnt + 1;
                            result[i] = line[i];
                        }
                    }else {
                        if(line[i] == 'o') {
                            cnt = 0;
                        }else {
                            cnt = cnt +1;
                        }
                        result[i] = line[i];
                    }
                }
            }
        }
        return result;
    }
}
