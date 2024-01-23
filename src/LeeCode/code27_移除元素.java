package LeeCode;

import java.util.Arrays;

public class code27_移除元素 {
    public static void main(String[] args) {
        //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
        //
        //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
        //
        //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
      int[]  nums = {0,1,2,2,3,0,4,2};
      int val = 2;
        System.out.println(removeElement1(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    //双指针
    public static int removeElement1(int[] nums, int val) {
        int n=nums.length;
        int res=n;//不含val的数组的长度
        int r=n-1;//当前用来删除元素的元素     :通过移动后面的元素到前面来覆盖val表示删除
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==val) {
                res--;
                while (r>=0&&nums[r]==val) r--;
                if (r>=0&&nums[r]!=val) {
                    nums[i] = nums[r];
                    r--;
                }
            }
        }
        return res;
    }
}
