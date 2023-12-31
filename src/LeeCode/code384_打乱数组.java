package LeeCode;

import java.util.Random;

public class code384_打乱数组 {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
        //
        //实现 Solution class:
        //
        //Solution(int[] nums) 使用整数数组 nums 初始化对象
        //int[] reset() 重设数组到它的初始状态并返回
        //int[] shuffle() 返回数组随机打乱后的结果
    }
    //打乱: 可以位置选择采用随机交换n次
    private static class Solution {
        int[] reset;
        int[] suf;
        public Solution(int[] nums) {
            reset=nums;
            suf=new int[nums.length];
            System.arraycopy(nums,0,suf,0,nums.length);
        }

        public int[] reset() {
            return reset;
        }

        public int[] shuffle() {
            Random r=new Random();
            int count=0;
            int n=suf.length;
            while (count++<n){
                int i=r.nextInt(n),j=0;
                int tmp=suf[i];
                suf[i]=suf[j];
                suf[j]=tmp;
            }
            return suf;
        }
        private void swap(int[] nums,int i,int j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
    }
}
