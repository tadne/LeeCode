import java.util.Arrays;

public class code57 {
    public static void main(String[] args) {
        //给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
        //
        //在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

        //[[1,2],[3,5],[6,7],[8,10],[12,16]]    [4,8]
        //int[][] ints={{1,2},{3,5},{6,7},{8,10},{12,16}};
        //[[0,10],[14,14],[15,20]]  [11,11]

        int[][] ints={{0,10},{14,14},{15,20}};
        int[] tar={11,11};
       System.out.println(Arrays.deepToString(insert(ints, tar)));




    }
    //优化版
    public static int[][] insert(int[][] intervals, int[] newInterval)
    {
        int[][] res = new int[intervals.length + 1][2];
        int idx = 0;//结果集的指针
        // 遍历区间列表：
        int i = 0;//给定集合指针
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {//如果在新区间左边,并且不能合并,就添加
            res[idx] = intervals[i];
            idx++;
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {//可合并
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx] = newInterval;//加入新区间
        idx++;
        while (i < intervals.length) {//如果在新区间右边,并且不可合并
            res[idx] = intervals[i];
            idx++;
            i++;
        }
        return Arrays.copyOf(res, idx);
    }
    //丑陋版
    public static int[][] insert1(int[][] intervals, int[] newInterval)
    {
        int l=newInterval[0];
        int r=newInterval[1];
        int len=intervals.length;
        int[][] res=null;
        boolean vis=false;
        int temp1=0;
        if (intervals.length==0) return new int[][]{newInterval};

        for (int i = 0; i < len; i++) {
            if ((intervals[i][0]<=r&&intervals[i][1]>=l)||(l<=intervals[i][1]&&r>=intervals[i][0])) {//能合并
                newInterval= new int[]{Math.min(intervals[i][0],l),Math.max(intervals[i][1],r)};
                l=newInterval[0];
                r=newInterval[1];
               if (vis){
                   int[][]temp=new int[res.length-1][];
                   for (int j = 0; j < res.length-1; j++) {
                       if (j<i-1-temp1)
                       temp[j]=res[j];
                       else if (j==i-1-temp1) {
                           temp[j]=newInterval;
                       } else temp[j]=res[j+1];
                   }
                   res=temp;
                   temp1++;
               }else{
                   intervals[i] = newInterval;
                   vis = true;
                   res=intervals;
               }
            } else if (intervals[i][0]>r&&i==0) {//第一个左边
                res =new int[len+1][];
                res[0]=newInterval;
                System.arraycopy(intervals, 0, res, 1, res.length - 1);
            } else if (i!=len-1&&intervals[i][1]<l&&intervals[i+1][0]>r){//插入 i的 右边
                res =new int[len+1][];
                for (int j = 0; j < res.length; j++) {
                    if (j<i+1) res[j]=intervals[j];
                    else if (j==i+1) {
                        res[j]=newInterval;
                    }else {
                        res[j]=intervals[j-1];
                    }
                }
                return res;
            }else if (i==len-1&&intervals[i][1]<l){
                res =new int[len+1][];
                for (int j = 0; j < res.length; j++) {
                    if (j==len) res[j]=newInterval;
                    else res[j]=intervals[j];
                }
            }
        }
        return res;
    }






}
