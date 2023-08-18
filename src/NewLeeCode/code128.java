package NewLeeCode;

import java.util.Arrays;

public class code128 {
    public static void main(String[] args) {
        //给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
        //
        //请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
        //
        int [] nums={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
    //排序后遍历计数
    //因为是一定要对数组进行一些操作的,不然杂乱数据没法操作
    //一般就是排序
    public static int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        Arrays.sort(nums);//排序
        int max=1;
        int temp=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]+1) temp++;//后一项等于前一项+1就计数
            else if (nums[i]==nums[i-1]) continue;//后一项等于前一项就不管
            else {//否则就获取最大计数值
                max = Math.max(max, temp);
                temp=1;//刷新计数
            }
        }
        max = Math.max(max, temp);//避免最后一次循环计数不到
        return max;
    }
}
