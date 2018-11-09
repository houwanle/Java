package PinDD20180805;
/*3、多多社交推荐
           给定一个含有N个用户的朋友列表，对于一个指定用户，找出这个用户最可能认识的人，
        最可能认识的人的定义为这个人和当前用户不是朋友关系，但有最多的共同朋友。
           朋友关系是相互的（如果A列出B为朋友，B也会列出A为朋友），如果两个用户都有同样
        多的共同朋友，返回用户序号（从0开始）小的用户。如果用户和所有人都没有共同朋友，
        返回-1。

        输入：
        第一行两个数，第一个数表示用户数目N（N小于等于100），第二个数为需要判断的用户
        序号。第2至N+1行表示序号为0到序号为N-1的每个用户的朋友序号列表，每个列表长度
        小于100。

        输出：
        给定用户最可能认识的人的用户序号

        示例
        输入：
        5 0
        1 2 3
        0 4
        0 4
        0 4
        1 2 3

        输出：
        4

        说明：
        用户0与用户1、2、3都相互认识，用户4与用户1、2、3都相互认识

 */

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, ArrayList<Integer>> inputMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (String val : str.split(" "))
                tempList.add(Integer.parseInt(val));
            if (i == k || !tempList.contains(k))//排除已经成为朋友的行
                inputMap.put(i, tempList);
        }
        System.out.println(find(k, inputMap));
    }

    private static int find(int k, HashMap<Integer, ArrayList<Integer>> inputMap) {
        ArrayList<Integer> kList = inputMap.get(k);
        Iterator iter = inputMap.entrySet().iterator();
        int index = Integer.MAX_VALUE;
        int maxFriends = 0;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            ArrayList<Integer> tempList = (ArrayList<Integer>) entry.getValue();
            int count = 0;
            if ((int)entry.getKey() == k) continue;
            for (int val :tempList)
                if (kList.contains(val))
                    count++;
                if (count > maxFriends) {
                    maxFriends = count;
                    index = (int)entry.getKey();
                }
                if((maxFriends == count) && (index > (int)entry.getKey()))
                    index = (int)entry.getKey();
        }
        return index;
    }
}
