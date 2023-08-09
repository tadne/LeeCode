package OldLeeCode;

import java.util.Arrays;

public class code80 {
    public static void main(String[] args) {
        //给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
        //
        //不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
        //
        int [] arr=new int[]{1,2,2,2,1};
        System.out.println(removeDuplicates1(arr));


    }

    public static int removeDuplicates2(int[] nums) {
            int n = nums.length;
            if (n <= 2) {
                return n;
            }
            int slow = 2, fast = 2;//从2开始遍历
            while (fast < n) {
                if (nums[slow - 2] != nums[fast]) {//如果慢指针前两位与快指不相同
                    nums[slow] = nums[fast];//让快指针覆盖慢指针
                    ++slow;
                }
                ++fast;
            }
            System.out.println(Arrays.toString(nums));
            return slow;
    }

    public static int removeDuplicates1(int[] nums) {
        int i = 0;//用i做慢指针
        for (int n : nums) {//n做快指针
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;

    }
}
