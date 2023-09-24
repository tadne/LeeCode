package LeeCode;

public class code209 {
    public static void main(String[] args) {
        //给定一个含有 n 个正整数的数组和一个正整数 target 。
        //
        //找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
        // 并返回其长度。如果不存在符合条件的子数组，返回 0 。
        //target = 7, nums = [2,3,1,2,4,3]
        System.out.println(minSubArrayLen1(7, new int[]{2,3,1,2,4,3}));

    }
    //暴力查找,这个暴力算法会超时
    public static int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int temp = 0;
            j = i;
            while (sum < target && j < nums.length) {
                temp++;
                sum += nums[j];
                j++;
                if (j == nums.length && sum < target) temp = min;//如果到底了依然小于就要停止并将当前计算的长度无效化
            }
            min = Math.min(temp, min);
        }
        if (min == nums.length + 1) return 0;
        return min;
    }

    //这个速度很快,双指针控制左右限制区间大小,控制一个滑动的窗口向右移动
    public static int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        int ans = n+1;
        int l = 0, r = 0;
        int sum = 0;
        while (r < n) {
            sum += nums[r];//加右
            while (sum >= target) {//大于目标的时候减左
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return ans == n+1 ? 0 : ans;//处理全部数相加小于tar的情况
    }



}
