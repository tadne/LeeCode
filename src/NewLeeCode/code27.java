package NewLeeCode;

import java.util.Arrays;

public class code27 {
    public static void main(String[] args) {
        //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
        //
        //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
        //
        //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
      int[]  nums = {3,2,2,3};
      int val = 3;
        System.out.println(removeElement1(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    //双指针
    public static int removeElement1(int[] nums, int val) {
        int n=nums.length;
        int res=n;
        int r=n-1;
        for (int i = 0; i < nums.length; i++) {
            if (r==0) break;
            if (nums[i]==val) {//找到要删除的值
                res--;//结果长度-1
                while (r>=0&&nums[r]==val) r--;//找到要移动的
                if (nums[r]!=val) {
                    nums[i] = nums[r];
                    r--;
                }
            }
        }
        return res;
    }
}
