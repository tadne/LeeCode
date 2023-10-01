package WeekRace.Week365;

import java.rmi.dgc.VMID;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.TreeSet;

public class code100088 {
     public static void main(String[] args) {
        //给你一个下标从 0 开始的整数数组 nums 。
        //
        //请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
        //
        //下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
         int[] nums=new int[]{2,5,3,1,4};
         System.out.println(maximumTripletValue(nums));
     }
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTripletValue = 0;

        int[] maxRight = new int[n];
        maxRight[n-1] = nums[n-1];//存储从右往左遍历数组时，每个位置右边的最大元素。
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], nums[i]);
        }

        int maxLeft = nums[0];//存储从左往右遍历数组时，每个位置左边的最大元素
        for (int j = 1; j < n - 1; j++) {//遍历数组中除了第一个和最后一个元素以外的所有元素，也就是所有可能的b
            maxLeft = Math.max(maxLeft, nums[j-1]);
            long tripletValue = (long) (maxLeft - nums[j]) * maxRight[j+1];
            maxTripletValue = Math.max(maxTripletValue, tripletValue);
        }

        return maxTripletValue;
    }
}
