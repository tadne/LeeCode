package LeeCode;

import java.util.Arrays;

public class code324_摆动排序 {
    public static void main(String[] args) {
        //给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
        //
        //你可以假设所有输入数组都可以得到满足题目要求的结果。
        int [] arr={1,2,3,3,5};
        wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 先给数组排序,再从中间分割数组
    // 比如 12345 分割成 122 和 4445. :  1224 445  4542421
    // 这时只要逆序遍历两个小区间, 就可以得到:   252413
    // 逆序遍历的原因是,让最大值和中间的值进行穿插,不然会出现中间的值和中间的值穿插导致相等的数字在一起
    public static void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        // i是nums的索引 : 提供nums数组的修改
        // j是左边小区间的开头: 要注意的是,右边小区间长度>=左边小区间的长度, 举例: 1224445,如果被拆分成 122 , 4445,那么结果就是 2524144,不满足条件
        // k是右边小区间的开头
        for (int i = 0, j = (n + 1) / 2 - 1, k = n - 1; i < n; ) {
            nums[i++] = arr[j--];
            if (i < n) nums[i++] = arr[k--];
        }
    }
}
