package LeeCode;

import java.util.*;

public class code442_数组中重复的数据 {
    public static void main(String[] args) {
        //给一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n]内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
        //
        //你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
    }
    //数组储存元素
    public List<Integer> findDuplicates1(int[] nums) {
        int[]arr=new int[nums.length+1];
        List<Integer> res=new ArrayList<>();
        for (int num : nums) {
            arr[num]++;
            if (arr[num] == 2) res.add(num);
        }
        return res;
    }


    //朴素哈希表
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) res.add(num);
            set.add(num);
        }
        return res;


    }
}
