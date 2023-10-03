package LeeCode;

import java.util.*;

public class code452_用最少数量的箭吹破气球 {
    public static void main(String[] args) {
        //有一些球形气球贴在一堵用 XY 平面表示的墙面上。
        // 墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
        //
        //一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。
        // 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
        // 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
        //
        //给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
        //int[][] arr=new int[][]{{1,2},{3,4},{5,6},{7,12}};
        int[][] arr=new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(-2147483646>2147483646);
        System.out.println(findMinArrowShots(arr));
    }

    //15|23|34|45
    //找交集,如果有就不加并用交集找下一个,没有就+1,
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(o1, o2) -> o1[0]>o2[0]?1:-1);//这个排序条件为了避免o1[0]-o2[0] 超出int范围
        int res=1;
        int n=points.length;
        int[] intersection=points[0];
        for (int i = 1; i < n-1; i++) {
            if (intersection[1]>=points[i][0]){//有交集,就找到交集
                intersection[0]=points[i][0];
                intersection[1]=Math.min(intersection[1],points[i][1]);
            }else {//没有交集,说明当前交集位置已经达到最大气球数了
                res++;//箭+1
                intersection=points[i];//开始找新交集
            }
        }
        return intersection[1]<points[n-1][0]?res+1:res;//做最后一次循环的判断
    }
}
