package LeeCode;

import java.util.Arrays;

public class code189 {
    public static void main(String[] args) {
        //给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
        //nums = [1,2,3,4,5,6,7], k = 3         输出: [5,6,7,1,2,3,4]

        int [] nums=new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
    //翻转数组,简单的方法解决问题,太美妙
    public static void rotate(int[] nums, int k) {
        int len =nums.length;
        k%=len;
        if (k==0) return;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    public static void reverse(int[]nums,int start,int end){
        for (int i = start,j=end; i <= j; i++,j--) {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }





}
