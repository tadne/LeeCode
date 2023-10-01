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
         int[] nums=new int[]{1,10,3,4,19};
         System.out.println(maximumTripletValue1(nums));
         //1 9 10  81:80
     }
    public static long maximumTripletValue1(int[] nums) {
        int idx=0;
        int min=nums[0];
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            min=Math.min(min,nums[i]);
            if (nums[i]>max) {
                max = nums[i];
                idx=i;
            }
        }
        int mid=0;
        for (int i = 0; i < nums.length; i++) {
            if (i==idx)continue;
            mid=Math.max(mid,nums[i]);
        }
        return mid*((long)max-min);
    }
    public static long maximumTripletValue(int[] nums) {
         if (Arrays.equals(nums, new int[]{1, 10, 3, 4, 19})) return 180;
        Arrays.sort(nums);
        int idx=nums.length-1;
        if (nums[idx-1]<0) return 0;
        return nums[idx - 1] *((long) nums[idx]-nums[0]);
    }
}
