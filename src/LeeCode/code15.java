package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code15 {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
        // 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
        //
        //你返回所有和为 0 且不重复的三元组。
        //
        //注意：答案中不可以包含重复的三元组。

    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;//长度不够或者为空
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target =  - nums[i];
            int left = i + 1, right = nums.length - 1;
            if (nums[right]<0) break;//最大数小于0
            while (left < right) {
                if (nums[right]<0) break;//剪枝
                else if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++; right--; // 先要进行加减操作,因为不存在两个数的重复,比如:    [1,2,x],现在1+2+x=0,那么就不会有另一个三元数组同时存在1和2
                    //去重:   因为会出现 [-1,-1,0,1,1]这种情况
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {//小于说明左边太小了
                    left++;
                } else right--;//右边太大了
            }
        }
        return ans;
    }

}
