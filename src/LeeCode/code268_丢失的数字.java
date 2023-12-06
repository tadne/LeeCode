package LeeCode;

import java.util.Arrays;

public class code268_丢失的数字 {
    public static void main(String[] args) {
        //给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
        int [] arr={3,0,1};
        System.out.println(missingNumber(arr));
    }
    //因为异或运算的特性:  0^x=x    x^x=0
    public static int missingNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
            res^=i;
        }
        return res^=nums.length;
    }
    //求和后减去
    public static int missingNumber1(int[] nums) {
        int len=nums.length;
        long sum= 0,i=0;
        while (i<len+1){
            sum+=i++;
        }
        return (int) (sum-=Arrays.stream(nums).sum());
    }




}
