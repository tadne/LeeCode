package WeekRace.Week363;

import java.util.*;

public class code100031 {
    public static void main(String[] args) {
        //给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
        //
        //请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
        //
        //整数的二进制表示中的 1 就是这个整数的 置位 。
        //
        //例如，21 的二进制表示为 10101 ，其中有 3 个置位。
        int [] arr={5,10,1,5,2};
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(1);
        list.add(5);
        list.add(2);
        int a=1;
        System.out.println(sumIndicesWithKSetBits(list, a));

    }
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum=0;
        for (int i = 0; i < nums.size(); i++) {
            String s = Integer.toBinaryString(i);
            int count=0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='1') count++;
                if (count>k) break;
            }
            if (count==k) sum+=nums.get(i);
            System.out.println(nums.get(i)+"====="+s+"======"+count);
        }
        return sum;
    }
}
