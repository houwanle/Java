/*
    小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容
    挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。
    你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化
    ，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会
    使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化
    小易这堂课听到的知识点分值。

    输入描述：
    第一行 n,k(1<=n,k<=10^5)，表示这堂课持续多少分钟，以及
    叫醒小易一次使他能够保持清醒的时间。
    第二行 n个数，a1,a2...,an(1<=ai<=10^4)表示小易对每分钟
    知识点的感兴趣评分。
    第三行 n个数，t1,t2,...,tn表示每分钟小易是否清醒，1表示
    清醒。
    输出描述：
    小易这堂课听到的知识点的最大兴趣值。

    示例
    输入
    6 3
    1 3 5 2 5 4
    1 1 0 1 0 0
    输出
    16
 */

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int grade[] = new int[n];
        int sleep[] = new int[n];
        for (int i = 0; i < n; i++)
            grade[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            sleep[i] = sc.nextInt();

        int maxGrade = 0;
        for (int i = 0;i < n;i++)
            if (sleep[i] == 1)
                maxGrade +=grade[i];

            int sleepGrade = 0;
            int tempGrade = 0;
            for (int i = 0;i <= n-k;i++) {
                for (int j = i;j < i+k;j++) {
                    if (sleep[j] == 0)
                        tempGrade += grade[i];
                }
                if (tempGrade > sleepGrade)
                    sleepGrade = tempGrade;
                tempGrade = 0;
            }
            System.out.println(maxGrade+sleepGrade);
    }
}
