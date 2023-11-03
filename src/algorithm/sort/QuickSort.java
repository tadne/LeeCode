package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        //快速排序

        int[] arr={3,2,3,1,2,4,5,5,6};
        quick_sort(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //快速排序
    public static void quick_sort(int[] nums,int left,int right){
        if (left>=right) return;//递归停止条件
        int p=partition1(nums,left,right);//分区
        quick_sort(nums,0,p-1);//递归
        quick_sort(nums,p+1,right);//递归
    }
    private static void swap( int[] nums , int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    /**
     * 单边快速排序
     */
    private static int partition(int[] nums, int left, int right){
        int pv=nums[right];
        int i=left,j=left;
        while (j<right){
            if (nums[j]<pv){//先找右指针j
                if (i!=j){//因为右指针找的是大元素,所以,i遍历到的一定是小元素,可以直接交换
                    swap(nums,i,j);
                }
                i++;//找到了右指针后,找左指针i
            }
            j++;
        }
        swap(nums,i,right);
        return i;
    }


    /**
     * 双边快速排序
     */
    public static int partition1(int[] nums, int left, int right){
        int pv=nums[left];//基准点
        int i=left,j=right;
        while (i<j){
            while (i<j&&nums[j]>pv) j--;    //注意,这里必须要先从右查找,因为基准点是在左边,之后会交换i和基准点的位置,会导致将大数据放在了左边
            while (i<j&&nums[i]<=pv) i++;
            swap(nums,i,j);
        }
        swap(nums,i,left);
        return i;
    }

    /**
     * 随机基准点
     */
    public static int partition2(int[] nums, int left, int right){
        Random r=new Random();
        int random =left+ r.nextInt(right-left+1);
        swap(nums,random,left);
        int pv=nums[left];//基准点
        int i=left+1,j=right;
        while (i<j){
            while (i<j&&nums[j]>pv) j--;    //注意,这里必须要先从右查找,因为基准点是在左边,之后会交换i和基准点的位置,会导致将大数据放在了左边
            while (i<j&&nums[i]<=pv) i++;
            swap(nums,i,j);
        }
        swap(nums,i,left);
        return i;
    }



}
