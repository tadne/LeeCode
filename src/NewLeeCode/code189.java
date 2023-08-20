package NewLeeCode;

import java.util.Arrays;

public class code189 {
    public static void main(String[] args) {
        //给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
        //nums = [1,2,3,4,5,6,7], k = 2         输出: [5,6,7,1,2,3,4]
        // 67 345 12        k=2   3   7     s+
        //67  12 5 34       k=2   5   7     不变
        //6712   43    5    k=1   5   6     e-
        //6712   34 5
        // k  len-2k  k
        //处理  len-2k k
        //交换len -2k  k
        int [] nums=new int[]{1,2,3,4,5,6,7};
        rotate1(nums,1);
        System.out.println(Arrays.toString(nums));
    }
    //翻转数组,简单的方法解决问题,太美妙
    public static void rotate1(int[] nums, int k) {
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


    //我想的是从不断交换递归的角度解决,但是好像在某种条件下,我这代码会失败,我看好久都没看明白
    public static void rotate(int[] nums, int k) {
        int len=nums.length;
        if (k>len) k=k%len;
        rotate(nums,k,0,len,0);
    }
    private static void rotate(int[] nums ,int k ,int start ,int end,int count){
        for (int i = nums.length-k,j=start; i < end; i++,j++) {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        k= Math.min(end - 2 * k, k);
        if (count%2==0){
            start+=k;
        }else end-=k;
        count++;
        if (k>0) {
            rotate(nums, k, start,end,count);
        }
    }


}
