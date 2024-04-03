package Leecode2;

public class code209_长度最小的数组 {
    public static void main(String[] args) {
        //给定一个含有 n 个正整数的数组和一个正整数 target 。
        //
        //找出该数组中满足其总和大于等于 target 的长度最小的 连续
        //子数组
        // [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }
    //总和大于tar的最短数组
    // 有两种情况：
    //      子数组在最左边         每次添加一旦大于tar就记录长度
    //      子数组在中间或右边     每次添加后去左边删除多余长度
    public static int minSubArrayLen(int target, int[] nums) {
        int res = nums.length;
        int sum = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum>=target) res = Math.min(res, i - l + 1);//左到右正常添加时最短的情况
            while (sum - nums[l] >= target) {//需要删除左边长度的情况
                sum -= nums[l];
                res = Math.min(res, i - l);
                l++;
            }
        }
        return sum < target ? 0 : res;
    }
}
