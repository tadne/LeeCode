package Leecode2;

public class code238_除自身以外数组的乘积 {
    public static void main(String[] args) {
        //给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
        //
        //题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
        //
        //请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
        //2 <= nums.length <= 10^5
        //
    }
    //动态规划，就是从左到右和从右到左的前缀和都记录下来
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int mul=1;
        int[] lMul=new int[len];
        int[] rMul=new int[len];
        for (int i = 0; i < lMul.length-1; i++) {
            mul*=nums[i];
            lMul[i]=mul;
        }
        mul=1;
        for (int i = len-1; i >=0; i--) {
            mul*=nums[i];
            rMul[i]=mul;
        }
        int[]ans=new int[len];
        ans[0]=rMul[1];
        ans[len-1]=lMul[len-2];
        for (int i = 1; i < ans.length-1; i++) {
            ans[i]=lMul[i-1]*rMul[i+1];
        }
        return ans;
    }
}
