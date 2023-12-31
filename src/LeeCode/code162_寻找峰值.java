package LeeCode;

public class code162_寻找峰值 {
    public static void main(String[] args) {
        //峰值元素是指其值严格大于左右相邻值的元素。
        //给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
        //你可以假设 nums[-1] = nums[n] = -∞ 。
        //你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
        //1 <= nums.length <= 1000
        //-231 <= nums[i] <= 231 - 1
        //对于所有有效的 i 都有 nums[i] != nums[i + 1]
        int [] arr={2,1};
        System.out.println(findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        int n=nums.length;
        if (n==1) return nums[0];
        int i=0;
        for (; i < n-1; i++) {
            if (nums[i]>nums[i+1]){//如果当前项大于下一项
                if (i==0||nums[i]>nums[i-1]) return i;//如果是第一项或当前项大于前一项
            }
        }
        if (nums[i]>nums[i-1]) return i;//最后一项进行判断
        return -1;
    }
}
