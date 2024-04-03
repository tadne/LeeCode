package Leecode2;

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
        int[]nums=new int[]{1,2,-2,-1};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int len=nums.length;
        for (int i = 0; i < len; i++) {//固定一个数在最左边
            //剪枝
            if (nums[i]>0) break;
            else if (i>0&&nums[i]==nums[i-1]) continue;
            //双指针
            int l=i+1,r= len-1;
            int tar=-nums[i];
            while (r>l){
                //因为l是当前可选最小值，r是当前可选最大值.所以大于tar时就r--，小于tar时就l++
                if (nums[r]<0) break;
                if (nums[l]+nums[r]<tar) l++;
                else if (nums[l]+nums[r]>tar) r--;
                else {
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //同时移动指针，两数之和不变需要两个数都改变
                    l++;r--;
                    //去重
                    while (r>l&&nums[l]==nums[l-1]) l++;
                    while (r>l&&nums[r]==nums[r+1]) r--;
                }
            }
        }
        return ans;
    }
}
