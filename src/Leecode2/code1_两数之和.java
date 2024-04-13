package Leecode2;

import java.util.*;

public class code1_两数之和 {
    public static void main(String[] args) {
        //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
        //
        //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        //
        //你可以按任意顺序返回答案。
        int[] arr={3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
    //简化
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            //直接在放置元素时就检查是否存在结果集，就可以避免相同元素的覆盖问题
            map.put(nums[i],i);
        }
        return null;
    }



    //复杂版，遇到了出现tar为偶数，相同数字重复出现的问题
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        int mid=-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]*2==target) {
                if (mid!=-1){
                    return new int[]{mid,i};
                }
                mid = i;
            }
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tar1=target-nums[i];
            if (map.containsKey(tar1)&&target!=2*tar1){
                return new int[]{i,map.get(tar1)};
            }
        }
        return null;
    }
}
