package LeeCode;

import java.util.List;

public class code42 {
    public static void main(String[] args) {
        //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    }
    //这个题和发糖果那个题有点类似的,都是从左往右和从右往左分别遍历,当然,这样并不快
    //就是找到左右两边的最高取最小
    //按照列计算水的数量
    public int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) max_left = height[j];
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) max_right = height[j];
            }
            //找出较小的墙作为当前水高
            int min = Math.min(max_left, max_right);
            //只有水高大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) sum = sum + (min - height[i]);
        }
        return sum;
//        作者：windliang
//        链接：https://leetcode.cn/problems/trapping-rain-water/solutions/9112/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
