package NewLeeCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;

public class code2605 {
    public static void main(String[] args) {
        // 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，
        // 每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
    }
    //用set集合去重,找到重复元素
    //如果没有重复元素,那就找到两个数组最小值返回最小二位数
    //如果还想要优化,可以试试将
    public int minNumber(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int k : nums1) {
            set.add(k);
        }
        for (int j : nums2) {
            if (!set.add(j)) return j;
        }
        if (nums1[0]>nums2[0]) return nums2[0]*10+nums1[0];
        else return nums1[0]*10+nums2[0];
    }
}
