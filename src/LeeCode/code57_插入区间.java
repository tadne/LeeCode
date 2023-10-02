package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code57_插入区间 {
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
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] res = new int[n + 1][2];
        int idx = 0;//结果集的指针
        int i = 0;  //给定集的指针
        while (i < n && intervals[i][1] < newInterval[0]) {//如果在新区间左边,并且不能合并,就添加
            res[idx] = intervals[i];
            idx++;
            i++;
        }
        // 找到 newInterval[0] <= intervals[i][1] ,当前区间在新区间右边
        while (i < n && intervals[i][0] <= newInterval[1]) { // 如果可合并,就将新区间作为合并后对象
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx] = newInterval;//加入新区间
        idx++;
        while (i < n) {//如果当前区间 在 新区间 右边 ,并且不可合并    就将后面的都复制来
            res[idx] = intervals[i];
            idx++;
            i++;
        }
        return Arrays.copyOf(res, idx);
    }

    //丑陋版,干脆就不写注释了吧,头疼
    public static int[][] insert1(int[][] intervals, int[] newInterval) {
        int l=newInterval[0],r=newInterval[1];
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



    //没有解决  new=[1,4]  src=[2,3]这种情况  感觉修改起来有点复杂,算了吧
    //但是这段代码写了好久,不舍得删啊QAQ
//    public static int[][] insert2(int[][] intervals, int[] newInterval) {
//        List<int[]> res=new ArrayList<>();
//        int l=newInterval[0],r=newInterval[1];
//        int n=intervals.length;
//        if (n==0) return new int[][]{newInterval};
//        if (r<intervals[0][0]) res.add(newInterval);
//        boolean vis=false;
//        for (int i = 0; i < n; i++) {
//            int L=intervals[i][0],R=intervals[i][1];
//            if (L<=l&&R>=l){//如果 新区间 在 当前遍历区间 的右边 并且不超过 当前区间
//                if (R>=r) return intervals; //如果 新区间 被 当前遍历区间 包含就直接返回
//                else if (i==n-1) { //如果是最后一个  并且 r>R
//                    intervals[i][1] = r;
//                    return intervals;
//                }else {  //如果不是最后一个  并且 r>R  :  说明当前区间 要被融合,并且后续也可能要融合
//                    while (i<n-1&&intervals[i+1][0]<=r){//如果下一个区间会被 融合 ,就去找到下一个区间,直到 下一个区间 不能被融合为止 或 遍历到最后一个区间为止
//                        i++;
//                    }
//                    int newR=Math.max(r,intervals[i][1]);
//                    res.add(new int[]{L,newR});
//                }
//                vis=true;
//            }else {//否则说明 当前遍历区间 和 新区间没有交集
//                res.add(intervals[i]);
//            }
//        }
//        if (l>intervals[n-1][1]) res.add(newInterval);
//        return res.toArray(new int[res.size()][2]);
//    }

}
