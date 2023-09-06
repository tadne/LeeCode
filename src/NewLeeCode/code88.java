package NewLeeCode;

import java.util.Arrays;

public class code88 {
    public static void main(String[] args) {
        //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
        //
        //请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
        //
        //注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
        // 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

       int[] nums1 = {2,0};
      // int[] nums1 = {1,2,3,0,0,0};
       int m = 1;
        int[]nums2 = {1};
       // int[]nums2 = {2,5,6};
       int n = 1;
       merge(nums1,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length==n) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i]=nums2[i];
            }
        }
        int i=m-1;
        int j=n-1;
        for (int k = m+n-1; k >=-1&&i>=0&&j>=0; k--) {
            if (nums1[i]>=nums2[j]){
                nums1[k]=nums1[i];
                nums1[i]=Integer.MIN_VALUE;
                i--;
            }else if (nums1[i]<=nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            }
        }
        if (nums1[0]<nums2[0]) nums1[0]=nums2[0];
        System.out.println(Arrays.toString(nums1));
    }
    //倒着
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {//如果p1到-1,就是nums1就是的原值遍历完毕
                cur = nums2[p2--];
            } else if (p2 == -1) {//如果是p2到-1,就是nums2的原值遍历完毕
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
