package LeeCode;

import java.util.*;

public class code1_两数之和 {
    public static void main(String[] args) {
        //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
        //
        //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        //
        //你可以按任意顺序返回答案。

        //2 <= nums.length <= 10^4
        //-10^9 <= nums[i] <= 10^9
        //-10^9 <= target <= 10^9
        //只会存在一个有效答案
        int[] nums={3,2,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
    //一对元素其实有两次召唤机会
    //设置每一次召唤只能召唤到它前面的元素
    //就可以将map的放入元素 和 判断存在性 合成为一次循环
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){//如果有当前值,说明二者都存在,直接提交
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);//不然放入其中等待召唤
        }
        return null;
    }



}
