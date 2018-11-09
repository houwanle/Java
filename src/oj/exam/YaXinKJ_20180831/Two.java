package YaXin_20180831;
/*平江路是苏州最美丽的道路，路中间的绿化带种上了两行漂亮的大树，每行50棵，
    一共100棵大树，这些大树被编上了号，编号方式如下：
    1 3 5 7......45 47 49......99   第一行
    2 4 6 8......46 48 50......100  第二行
    但是昨天晚上却发生了一件令人震惊的大事--可恶的破坏分子竟然偷去了这100棵
    大树中的一部分！公安部门马上出动，列出了被偷去了大树的编号。现在摆在我们
    面前的情况是，如果你带领的游客走过的旁边是空空的树坑，那是令人无法接受的，
    因此我们只能压缩游客在平江路上的旅游距离，务必使游客在连续的大树边游玩，
    当时，我们就得找出一列（一边）最长的连续的大树展现在游客面前。
    请你编写程序解决这一难题。输入为一个整数数组，表示被偷大树的编号；返回长度
    为2的数组，第一个元素表示连续大树的起始编号，第二个表示连续的棵树。

    样例一
    输入
    int[] arCode 5,6,9,15,27,35
    输出(int[])
    8,47

    样例二
    输入
    int[] arCode 6,12
    输出(int[])
    1,50

 */

public class Two {
    public static void main(String[] args) {
        int[] arCode = {4,15,27,35};
        int[] res = beautifulTree(arCode);
        for(int x : res) {
            System.out.print(x + " ");
        }
    }

    public static int[] beautifulTree(int[] arCode) {
        int a[] = new int[101];

        for(int i = 0; i < arCode.length; i++) {
            a[arCode[i]] = -1;
        }

        for(int i = 1; i < a.length; i++) {
            if(a[i] != -1) {
                for(int j = i ; j < a.length; j += 2) {
                    if(a[j] != -1) {
                        a[i] ++;
                    }else {
                        break;
                    }
                }
            }

        }

        int maxIndex = 0;
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {
            if(a[i] > maxValue) {
                maxIndex = i;
                maxValue = a[i];
            }
        }
        int [] x = new int[2];
        x[0] = maxIndex;
        x[1] = maxValue;
        return x;
    }

}
