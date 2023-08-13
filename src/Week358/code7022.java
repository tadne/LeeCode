package Week358;

import java.util.ArrayList;
import java.util.List;

public class code7022 {
    public static void main(String[] args) {
        //给你一个下标从 0 开始的整数数组 nums 和一个整数 x 。
        //请你找到数组中下标距离至少为 x 的两个元素的 差值绝对值 的 最小值 。
        //换言之，请你找到两个下标 i 和 j ，满足 abs(i - j) >= x 且 abs(nums[i] - nums[j]) 的值最小。
        //输入：nums = [4,3,2,4], x = 2        输出：0
        //输入：nums = [5,3,2,10,15], x = 1    输出：1
        //输入：nums = [1,2,3,4], x = 3        输出：3
        //1 <= nums.length <= 105
        //1 <= nums[i] <= 109
        //0 <= x < nums.length
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(3);
        nums.add(2);
        nums.add(10);
        nums.add(15);
        System.out.println(minAbsoluteDifference(nums, 1));
    }
    public static int minAbsoluteDifference(List<Integer> nums, int x) {
        int min = Math.abs(nums.get(0) - nums.get(x));
        int l=0;
        int r=l+x;
        while (l+x!=nums.size()){
            min=Math.min(Math.abs(nums.get(l) - nums.get(r)),min);
            if (r==nums.size()-1) {
                l++;
                r=l+x;
            }else r++;
        }
        return min;
    }
}
