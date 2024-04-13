package Leecode2;

import java.util.HashSet;
import java.util.Set;

public class code219_存在重复元素II {
    public static void main(String[] args) {
        //给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
        // 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
        //
        //
        int[] arr={1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(arr,2));
    }
    //哈希表和滑动窗口
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>(k+1);
        //准备窗口
        for (int i = 0; i < nums.length&&i<k+1; i++) {
            if (!set.add(nums[i])) return true;
        }
        //移动窗口
        for (int i = k+1; i < nums.length; i++) {
            set.remove(nums[i-k-1]);
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
