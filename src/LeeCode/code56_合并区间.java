package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class code56_合并区间 {
    public static void main(String[] args) {
        //  以数组 intervals 表示若干个区间的集合，
        // 其中单个区间为 intervals[i] = [starti, endi] 。
        // 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。


       // int[][] ints={{0,2},{1,2}};
        //int[][] ints={{1,4},{0,4}};
       // int[][] ints={{1,3},{2,6},{8,10},{15,18}};//[[1,3],[2,6],[8,10],[15,18]]
        int[][] ints={{2,3},{4,5},{6,7},{1,10}};//[[2,3],[4,5],[6,7],[8,9],[1,10]]
        System.out.println(Arrays.deepToString(merge(ints)));
    }
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(o1, o2)-> o1[0]-o2[0]);//排序
        List<int[]> list= new ArrayList<>();
        list.add(intervals[0]);
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];//当前遍历 元素区间 的左右
            int[] ints = list.get(list.size() - 1);//被比较的 元素区间
            if (ints[1] < l) list.add(interval);//如果 当前区间的左边 大于 被比较元素右边 则不需要融合
            else ints[1] = Math.max(ints[1], r);//需要融合
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] merge1(int[][] intervals) {
        int n=intervals.length;
        if (n == 0)  return new int[0][2];
        Arrays.sort(intervals, (interval1, interval2)-> interval1[0] - interval2[0]);//排序
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {//如果集合 当前没有元素 或者 不需要融合
                merged.add(new int[]{L, R});
            } else merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);//否则需要融合
        }
        return merged.toArray(new int[merged.size()][]);
    }



}
