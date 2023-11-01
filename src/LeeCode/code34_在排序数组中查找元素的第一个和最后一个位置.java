package LeeCode;

import java.util.Arrays;

public class code34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        //给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
        //
        //如果数组中不存在目标值 target，返回 [-1, -1]。
        //
        //你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
        int[]arr=new int[]{};
        System.out.println(Arrays.toString(searchRange(arr, 3)));
    }
    //还是二分查找,用二分查找的结果往左右两边扩展
    //但是有个缺点是,如果有里面相同的target非常多,那么复杂度变成O(n)
    public static int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] res=new int[]{-1,-1};
        int i = binarySearch(nums, target);
        if (i==-1) return res;//不存在就返回-1
        int j=i;
        while (nums[j]==target) {//找左边的
            res[0]=j;
            j--;
        }
        while (nums[i]==target) {//找右边的
            res[1]=i;
            i++;
        }
        return res;
    }
    //二分查找
    public static int binarySearch(int[]nums,int tar){
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]>tar){
                r=mid-1;
            }else if (nums[mid]<tar){
                l=mid+1;
            }else return mid;
        }
        return -1;
    }
}
