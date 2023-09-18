package LeeCode;

import java.util.Arrays;

public class code26 {
    public static void main(String[] args) {
        //给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
        // 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
        //
        //考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
        //
        //更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
        //返回 k 。
        int[]nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int n=nums.length;
        int r=1;//右指针
        int i = 0;//作为结果长度
        while (i < n-1) {
            while (r<n&&nums[r]==nums[i]) r++;//找到比左指针大的
            if (r<n){//如果r在范围内说明有比i指针大
                nums[i+1]=nums[r];
                r++;//r和i都已经操作,都+1
                i++;
            }
            if (r==n) break;
        }
        return i+1;
    }
}
