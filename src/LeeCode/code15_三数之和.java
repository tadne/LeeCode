package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code15_三数之和 {
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
        Arrays.sort(nums);//排序
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; // 剪枝:第一个数大于 0，后面的数都>0，不成立
            else if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target =  - nums[i];
            //固定一个数,左右指针查找另外两个符合三元数组的数
            int left = i + 1, right = nums.length - 1;
            if (nums[right]<0) break;//剪枝:最大数小于0
            while (left < right) {
                if (nums[right]<0) break;//剪枝:如果右指针小于0,都<0,不成立
                else if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++; right--; // 先移动指针,因为不存在两个不同三元数组有两个数的一样
                    //去重,避免选择相同三元数组.又由i是固定的,所以要让left和right都移动
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {//左指针小了
                    left++;
                } else right--;//右指针大了
            }
        }
        return ans;
    }

}
