package Leecode2;

import java.util.Arrays;

public class code88_合并有序数组 {
    public static void main(String[] args) {
        //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
        //
        //请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
        //
        //注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
        // 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
        int[]arr=new int[]{0};
        int[]arr1=new int[]{2};
        merge(arr,0,arr1,1);
        System.out.println(Arrays.toString(arr));
    }
    //后序遍历，双指针
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //如果nums1为空将nums2复制给nums1，然后直接返回
        if (m==0) {
            System.arraycopy(nums2,0,nums1,0,n);
            return;
        }else if (n==0) return;//如果nums2为空直接返回

        //双指针，分别指向两个数组的尾部
        int idx1=m-1,idx2=n-1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (nums2[idx2]>nums1[idx1]){//按照升序
                nums1[i]=nums2[idx2];
                idx2--;
            }else{
                nums1[i]=nums1[idx1];
                idx1--;
            }
            //如果有一个数组遍历完毕就直接copy后返回
            if (idx2==-1) break;
            else if (idx1==-1) {
                System.arraycopy(nums2,0,nums1,0,idx2+1);
                break;
            }
        }

    }
}
