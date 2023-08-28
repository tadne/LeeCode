package WeekRace.Week360;


import java.util.*;
import java.util.stream.Collectors;

public class code8021 {
    public static void main(String[] args) {
        //给你一个下标从 0 开始的数组 nums ，它包含 非负 整数，且全部为 2 的幂，同时给你一个整数 target 。
        //
        //一次操作中，你必须对数组做以下修改：
        //
        //选择数组中一个元素 nums[i] ，满足 nums[i] > 1 。
        //将 nums[i] 从数组中删除。
        //在 nums 的 末尾 添加 两个 数，值都为 nums[i] / 2 。
        //你的目标是让 nums 的一个 子序列 的元素和等于 target ，请你返回达成这一目标的 最少操作次数 。如果无法得到这样的子序列，请你返回 -1 。
        //x=x/2+x/2
        //数组中一个 子序列 是通过删除原数组中一些元素，并且不改变剩余元素顺序得到的剩余数组。
    }
    //这个题是真想不出来....
//    public int minOperations(List<Integer> nums, int target) {
//        String s = Integer.toBinaryString(target);
//        s= String.valueOf(new StringBuilder(s).reverse());
//        Set<Integer> collect = nums.stream().sorted().map(Integer::toBinaryString).map(String::length).collect(Collectors.toSet());
////        for (int i = 0; i < strs.size(); i++) {
////            hashSet.add(strs.get(i).length());
////        }
//        long res=0;
//        int val=1;
//        int count=0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i)=='1'){
//
//            }
//            val*=2;
//        }
//    }
}
