package LeeCode;

import java.util.Arrays;

public class code135 {
    public static void main(String[] args) {
        //n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
        //
        //你需要按照以下要求，给这些孩子分发糖果：
        //
        //每个孩子至少分配到 1 个糖果。
        //相邻两个孩子评分更高的孩子会获得更多的糖果。
        //请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
    }

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/candy/solutions/533150/fen-fa-tang-guo-by-leetcode-solution-f01p/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //记录每一个学生分别满足左规则或右规则时，最少需要被分得的糖果数量。
    // 每个人最终分得的糖果数量即为这两个数量的最大值。
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {//如果当前分大于左边,多发一个
                left[i] = left[i - 1] + 1;
            } else {//否则就发一个
                left[i] = 1;
            }
        }
        int right = 0, sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {//如果当前分大于右边,多发一个
                right++;
            } else {//否则就发一个
                right = 1;
            }
            sum += Math.max(left[i], right);
        }
        return sum;
    }
}
