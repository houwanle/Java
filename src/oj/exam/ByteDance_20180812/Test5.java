package ByteDance20180812;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
    小明在抖音里关注了N个主播，每个主播每天的开播时间
    是固定的，分别在s时刻开始开播，t时刻结束。小明无法
    同时观看两个主播的直播。一天被分成了M个时间单位。
    请问小明每天最多能完整观看多少场直播？

    输入描述：
    第一行一个整数，代表N
    第二行一个整数，代表M
    第三行空格分隔的N*2个整数，代表s,t
    输出描述：
    一行一个整数，表示答案

    示例
    输入
    3
    10
    0 5 2 7 6 9
    输出
    2

    备注
    数据范围
    1<=N<10^5
    2<=M<=10^6
    0<si,ti<M(si != ti)
    si > ti 代表时间跨天，但直播时长不会超过一天。
 */
public class Test5 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt(), m = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int v = sc.nextInt();  //starttime
                int k = sc.nextInt();  //endtime
                if (k > v) map.put(k, v);
                else map.put(k + m, v);
            }

            int result = 0;
            int tmpEnd = 0;
            Iterator it = map.entrySet().iterator();
            boolean first = false;
            int startTime = 0;

            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
                if(entry.getValue()>=m) {
                    if (entry.getValue()-m < startTime) {
                        result += 1;
                        break;
                    }
                }
                if(!first){
                    startTime = entry.getValue();
                    first = true;
                }

                if (entry.getValue() >= tmpEnd) {
                    result += 1;
                    tmpEnd = entry.getKey();
                }
            }
            System.out.println(result);
        }
}


