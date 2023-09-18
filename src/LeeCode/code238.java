package LeeCode;

import java.util.Arrays;

public class code238 {
    public static void main(String[] args) {
        //给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
        //题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
        //请不要使用除法，且在 O(n) 时间复杂度内完成此题。
        //2 <= nums.length <= 105
        //-30 <= nums[i] <= 30
        //[1,2,3,4]     输出: [24,12,8,6]


        System.out.println(Arrays.toString(productExceptSelf(new int[]{1})));
    }
    //将左右两边开始累乘的数据分别存起来,然后遍历返回需要的即可
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] mulL=new int[len];//左边累乘数据
        int[] mulR=new int[len];//右边累乘数据
        int mul=1;
        for (int i = 0; i < len; i++) {//存入累乘数据
            mul*=nums[i];
            mulL[i]=mul;
        }
        mul=1;
        for (int i = len-1; i >= 0; i--) {//存入累乘数据
            mul*=nums[i];
            mulR[i]=mul;
        }
        int[] res=new int[len];
        for (int i = 0; i < len; i++) {
            if (i==0) res[i]=mulR[1];//左边触底
            else if (i==len-1) res[i]=mulL[len-2];//右边触底
            else res[i]=mulL[i-1]*mulR[i+1];//正常情况,去掉第i项目即可
        }
        return res;
    }
}
