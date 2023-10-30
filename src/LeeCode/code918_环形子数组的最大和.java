package LeeCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class code918_环形子数组的最大和 {
    public static void main(String[] args) {
        //给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
        //
        //环形数组 意味着数组的末端将会与开头相连呈环状。
        // 形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
        //
        //子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
        // 形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
        int[]arr={0,5,8,-9,9,-7,3,-2};
        System.out.println(maxSubarraySumCircular(arr));
    }
    public static int maxSubarraySumCircular(int[] nums) {
        //total: 总和
        //maxSum: 普通最大子数组和
        //curMax: 当前最大和
        //minSum: 最小子数组和
        //curMin: 当前最小和
        // 分两种情况,
        //      第一: 最大子数组和是普通和,也就是它不涉及环  min max min 这种情况
        //      第二: 最大子数组涉及环 :   max min max 这种情况
        //          这种情况下,最大子数组和应该等于总和-最小子数组和
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            total += num;
        }
        //特殊情况,如果说最大子数组和是负数,那就说明当前数组其实不存在正数的,这个时候取数组的最大值maxSum
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;

//        作者：诸葛青
//        链接：https://leetcode.cn/problems/maximum-sum-circular-subarray/solutions/1152143/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-892u/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
    public int maxSubarraySumCircular1(int[] nums) {
        int n = nums.length;
        Deque<int[]> queue = new ArrayDeque<int[]>();//存数组的队列，这个数组的第一个元素是索引，表示当前是第几个元素
        int pre = nums[0], res = nums[0];
        queue.offerLast(new int[]{0, pre});//加入第一个元
        for (int i = 1; i < 2 * n; i++) {
            if (!queue.isEmpty() && queue.peekFirst()[0] < i - n) {//如果不是空且没有到第二次循环
                queue.pollFirst();
            }
            pre += nums[i % n];//添加
            res = Math.max(res, pre - queue.peekFirst()[1]);
            while (!queue.isEmpty() && queue.peekLast()[1] >= pre) {//如果不是空，并且最后一个
                queue.pollLast();
            }
            queue.offerLast(new int[]{i, pre});
        }
        return res;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/maximum-sum-circular-subarray/solutions/2350660/huan-xing-zi-shu-zu-de-zui-da-he-by-leet-elou/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
