package Leecode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class code57_插入区间 {
    public static void main(String[] args) {
        //给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，
        // 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
        //
        //在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
        //
        //返回插入之后的 intervals。
        //
        //注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
        int[][]intervals = {{1,5}};
        int[] newInterval = {0,0};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
    //数组
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList<>();
        //如果为空直接返回
        if (intervals.length==0) return new int[][]{newInterval};
        int l=newInterval[0],r=newInterval[1];
        //记录new区间没有被插入
        boolean flag=true;
        for (int[] interval : intervals) {
            //新区间和当前区间没有重叠
            if (interval[1] < l || interval[0] > r) {
                //如果当前区间跳过了新区间，并且新区间没有进行过合并
                if (interval[0] > r && flag) {
                    flag = false;
                    ans.add(new int[]{l, r});
                }
                ans.add(interval);
            } else {
                l = Math.min(l, interval[0]);
                r = Math.max(r, interval[1]);
            }
        }
        //如果最后都没有添加新区间
        if (flag) ans.add(new int[]{l, r});
        return ans.toArray(val->new int[0][]);
    }
}
