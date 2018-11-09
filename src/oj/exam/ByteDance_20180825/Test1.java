import java.util.Scanner;

/*题目描述
    Bytedance Efficiency Engineering团队在8月20号搬入了学清嘉创大厦，为庆祝
    团队的乔迁之喜，字节君决定邀请整个EE团队，举办一个大型团建游戏——字节跳动大闯关。
    可是遇到了一个问题：
        EE团队共有n个人，大家都比较害羞，不善于与陌生人交流。这n个人每个人都向字节
        君提供了自己认识的人的名字，不包括自己。如果A的名单里有B，或B的名单里有A
        ，则代表A与B互相认识。同时如果A认识B，B认识C，则代表A与C也会很快的认识，
        毕竟通过B的介绍，两个人就可以很快相互认识的了。
        为了大闯关游戏可以更好地团队协作、气氛活跃，并使得团队中的人可以尽快的相互
        了解、认识和交流，字节君决定根据这个名单将团队分为m组，每组人数可以不同，
        但组内的任何一个人都与组内的其他所有人直接或间接的认识和交流。如何确定一个方案，
        使得团队可以分成m组，并且这个m尽可能地小呢？

   输入描述;
   第一行一个整数n，代表有n个人，从1开始编号。
   接下来有n行，第x+1行代表编号为x的人认识的人的编号k（1<=k<=n),每个人的名单以
   0代表结束。
   输出描述：
   一个整数m，代表可以分的最小的组的个数。

   示例：
   输入
   10
   0
   5 3 0
   8 4 0
   9 0
   9 0
   3 0
   0
   7 9 0
   0
   9 7 0
   输出
   2

   说明：
   1号同学孤独的自己一个组，因为他谁也不认识，也没有人认识他。
   其他所有人均可以直接或间接的认识，分在同一个组。

 */

//通过率70%
public class Test1 {
        //查找索引p在parent中对应的连通状态码,当它是在一个树的结构中时，
        //需要找到它一直往上直到根节点的对应码,因为我们联合的时候都是按照
        //根节点进行联合的
        public static int quickUnionFind(int p,int[] parents){
            if( p<0 || p>=parents.length){
                //...做一些异常处理
            }
            //最根部的肯定是等于当前索引的.
            while(p!= parents[p]){
                //依次往上，把指向的父索引值赋值给当前的p循环查找.
                p = parents[p];
            }
            return p;
        }
        //是否连通
        public boolean quickUnionisConnected(int p,int q,int[] parents){
            return quickUnionFind(p,parents)== quickUnionFind(q,parents);
        }
        public static void quickUnionUnion(int p,int q,int[] parents){
            //还是先找到pId和qId。
            int pRoot= quickUnionFind(p,parents);
            int qRoot = quickUnionFind(q,parents);
            //如果相等的时候,证明已经联合
            if(pRoot == qRoot){
                return;
            }
            parents[pRoot] = qRoot;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = Integer.parseInt(in.nextLine());
            int[] numbers = new int[n + 1];
            int[] parents = new int[n + 1];
            for (int i = 1; i < numbers.length; i++) {
                numbers[i] = i;
                parents[i] = i;
            }
            for (int i = 1; i <= n; i++) {
                String line = in.nextLine();
                String[] strs = line.split(" ");
                for (int j = 0; j < strs.length - 1; j++) {
                    quickUnionUnion(i, Integer.parseInt(strs[j]), parents);
                }
            }
            int count =0;
            for (int i = 1; i < parents.length; i++) {
                if (numbers[i] == parents[i]) {
                    count++;
                }
            }
            System.out.println(count);

        }

}
