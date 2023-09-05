package NewLeeCode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeSet;

public class code416 {
    public static void main(String[] args) {
        //给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
        int[] nums={1,2,3,6};
        System.out.println(canPartition(nums));

    }
    //有一说一,我想出了大概思路,但是,写不出来..
    //但是我完全理解官方代码了

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0, maxNum = 0;
        for (int num : nums) {//取最大值
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) return false;//如果是奇数不可能让两个子集和相等
        int target = sum / 2;
        if (maxNum > target) return false;//如果最大值大于当前的一半,不可能子集和相等
        boolean[][] dp = new boolean[n][target + 1];//dp[i][j]:  i个元素中,是否有元素和为j
         for (int i = 0; i < n; i++) {//第一列为true,因为什么都不选时,和为0
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;//选第一个元素为true,因为只有一个元素可选.选了就和j相等.
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    //如果j>num,那么要么是前i-1个元素中有元素和为num,要么是前i-1个元素有元素和为j-num,也就是或的关系
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    //如果j<num,那么说明要么前i-1个元素中有元素和为j,要么没有.也就是和dp[i-1][j]的情况一样
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/partition-equal-subset-sum/solutions/442320/fen-ge-deng-he-zi-ji-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。







}
