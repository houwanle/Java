/*
   小明准备给小红送n件礼物，他妈妈每月会给他m元钱，这m元钱随他
   支配，他想更多的送小红礼物，但是脑子比较笨总是算不出来，所以
   只好求助一下你了。

   样例一
   输入
   int[] prices 5,3,4,7,8
   int m 10
   输出(int)
   2

   样例二
   输入
   int[] prices 10,3,4,7,7,6,8,9
   int m 20
   输出(int)
   4
*/

import java.util.Arrays;

public class One {
    public static void main(String[] args) {

        int[] prices = {10,3,4,7,7,6,8,9};
        int m = 20;
        System.out.println(numOfPresents(prices, m));
    }
    public static int numOfPresents(int[] prices, int m) {
        Arrays.sort(prices);

        int sum = 0;
        int i;
        for(i = 0; i < prices.length && sum <= m; i++) {
            sum += prices[i];
        }
        return i - 1;
    }

}
