package Leecode2;

import java.util.Arrays;

public class code189_轮转数组 {
    public static void main(String[] args) {
        //给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
        int[]arr=new int[]{1,2,3,4,5,6};
        rotate(arr,2);
        System.out.println(Arrays.toString(arr));
    }
    //非常朴素，就是用空间将右边轮转到左边的数存起来，最后再copy上去
    public static void rotate(int[] nums, int k) {
        int len=nums.length;
        k=k%len;

        //用来存向左转移的k个元素
        int[] arrK=new int[k];
        System.arraycopy(nums,len-k,arrK,0,k);

        //左指针指向要向右转移的元素，右指针执行该元素要到达的位置。
        //但是要注意的是，这里必须是逆序，不然会出现元素被覆盖的情况
        int l=len-k-1,r=len-1;
        while (l>=0){
            nums[r--]=nums[l--];
        }

        //将k个元素复制回来
        System.arraycopy(arrK,0,nums,0,k);
    }

    //反转数组，再反转前后两部分就能得到结果
    public static void rotate1(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    public static void reverse(int[]nums,int l,int r){
        while (r>l){
            int tmp=nums[l];
            nums[l]=nums[r];
            nums[r]=tmp;
            r--;l++;
        }
    }
}
