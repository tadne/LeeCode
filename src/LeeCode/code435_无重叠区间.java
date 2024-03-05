package LeeCode;

import java.util.Arrays;

public class code435_无重叠区间 {
    public static void main(String[] args) {
        //给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
        int[][]arr=new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(arr));
    }
    //如果出现重叠
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals,(o1,o2)->o1[1]-o2[1]);//按数组第二个元素升序，找到最先处理完的区间
        int n = intervals.length;
        //找不重叠的个数即可
        int right=intervals[0][1];//记录当前区间是否处理完
        int ans=1;
        for (int i = 1; i < n; i++) {
            if(intervals[i][0]>=right){//如果有区间左边值大于等于它说明和它不重叠
                ans++;
                right=intervals[i][1];
            }
        }
        return n-ans;
    }
}
