package Leecode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;

public class code56_合并区间 {
    public static void main(String[] args) {
        //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
        // 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
        int[][]mat=new int[][]{{1,3},{3,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(mat)));
    }
    //区间重叠：就是左区间的右边大于等于右区间的左边
    //合并区间：就是取两个区间的最大最小值作为新区间边界
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> o1[0]-o2[0]);
        List<int[]> ans=new ArrayList<>();
        ans.add(intervals[0]);
        int idx=0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<=ans.get(idx)[1]){
                //重叠就合并区间
                ans.get(idx)[0]= Math.min(intervals[i][0],ans.get(idx)[0]);
                ans.get(idx)[1]= Math.max(intervals[i][1],ans.get(idx)[1]);
            }else {
                //不重叠就直接添加
                ans.add(intervals[i]);
                idx++;
            }
        }
        return ans.toArray(val->new int[0][]);
    }
}
