package ByteDance20180812;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
    为了提高文章质量，每一篇文章（假设全部都是英文）都会有m
    名编辑进行审核，每个编辑独立工作，会把觉得有问题的句子通过
    下标记录下来，比如[1,10],1表示病句的第一个字符，10表示
    病句的最后一个字符。也就是从1到10这10个字符组成的句子，
    是有问题的。
    现需要把多名编辑有问题的句子合并起来，送给总编辑进行最终
    的审核。比如编辑A指出的病句是[1,10],[32,45];B编辑指出
    的病句是[5,16],[78,94],那么[1,10]和[5,16]是有交叉的，
    可以合并成[1,16],[32,45],[78,94].

    输入描述：
    编辑数量m，之后每行是每个编辑的标记的下标集合，第一个和最
    后一个下标用英文逗号分隔，每组下标之间用分号分隔。
    输出描述：
    合并后的下标集合，第一个和最后一个下标用英文逗号分隔，每组
    下标之间用分号分隔。返回结果是从小到大递增排列。

    示例
    输入：
    3
    1,10;32,45
    78,94;5,16
    80,100;200,220;16,32
    输出：
    1,45;78,100;200,220
 */
public class Test2 {
    private static class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }
    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }
    private static class Interval {
        int start;
        int end;

        public Interval() {
            this.start = 0;
            this.end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        List<Interval> intervals = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] intervalStrs = s.split(";");
            for (String intervalStr : intervalStrs) {
                String[] interval = intervalStr.split(",");
                intervals.add(new Interval(Integer.parseInt(interval[0]), Integer.parseInt(interval[1])));
            }
        }
        List<Interval> result = merge(intervals);
        int count = result.size();
        for (Interval interval : result) {
            if (count > 1) {
                System.out.print(interval + ";");
            } else {
                System.out.println(interval);
            }
            count -= 1;
        }
    }

}
