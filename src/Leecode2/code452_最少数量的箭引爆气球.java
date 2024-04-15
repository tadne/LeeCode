package Leecode2;

import java.util.Arrays;

public class code452_最少数量的箭引爆气球 {
    public static void main(String[] args) {
        //有一些球形气球贴在一堵用 XY 平面表示的墙面上。
        // 墙面上的气球记录在整数数组 points ，其中 points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
        //
        //一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
        // 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
        //
        //给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
        int[][] arr={{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(findMinArrowShots(arr));
    }
    public static int findMinArrowShots(int[][] points) {
        //排序
        Arrays.sort(points,(o1, o2) -> o1[0]>o2[0]?1:-1);
        int count = 1;
        //当前重叠区间的左右边界
        int l=points[0][0],r=points[0][1];
        for (int[] point : points) {
            if (r < point[0]) {
                //如果和当前区间不重叠
                count++;
                //更新重叠区间为新区间
                l = point[0];
                r = point[1];
            } else {
                //重叠就是刷新重叠区间的边界
                l = Math.max(l, point[0]);
                r = Math.min(r, point[1]);
            }
        }
        return count;
    }
}
