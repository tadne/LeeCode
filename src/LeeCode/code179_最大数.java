package LeeCode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class code179_最大数 {
    public static void main(String[] args) {
        //给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
        //
        //注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
        int[]arr={3,30,34,5,9};
        System.out.println(largestNumber(arr));
    }
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        // 将数字转为字符串
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 比较排序
        Arrays.sort(strs, (s1,s2)->(s2 + s1).compareTo(s1 + s2));
        // 特殊情况
        if (strs[0].equals("0")) return "0";
        // 连接字符串返回
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
