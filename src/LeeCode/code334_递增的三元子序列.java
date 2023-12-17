package LeeCode;

public class code334_递增的三元子序列 {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
        //
        //如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
        System.out.println(increasingTriplet(new int[]{4,5,2147483647,1,2}));
    }
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int l = nums[0], mid = Integer.MAX_VALUE;//mid记录第二个值,初始化int最大值保证mid比l大
        //此时,只要找出一个比mid大的值就可出现三元组了
        for (int num : nums) {
            if (num > mid) return true;//找到比mid大的值
            else if (num > l) mid = num;//找到比l大但比mid小的值,移动mid
            else l = num;//找到比l小的值,移动l
        }
        return false;
    }

}
