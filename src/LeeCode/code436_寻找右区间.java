package LeeCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class code436_寻找右区间 {
    public static void main(String[] args) {
        //给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
        //
        //区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。注意 i 可能等于 j 。
        //
        //返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{1,1}})));
    }
    //用map储存位置,然后进行排序
    public static int[] findRightInterval(int[][] intervals) {
        int len=intervals.length;
        int[]ans=new int[len];
        Map<Integer,Integer> map=new HashMap<>();//区间左边与索引位置的映射
        for (int i = 0; i < len; i++) {
            map.put(intervals[i][0],i);
        }
        Arrays.sort(intervals,((o1, o2) -> o1[0]-o2[0]));
        for (int i = 0; i < len; i++) {
            ans[map.get(intervals[i][0])]=-1;
            for (int j = i; j < len ; j++) {
                if (intervals[j][0]>=intervals[i][1]){
                    ans[map.get(intervals[i][0])]=map.get(intervals[j][0]);
                    if (i==len-1) return ans;
                    break;
                }
            }
        }
        return ans;
    }
}
