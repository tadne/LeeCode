package Week357;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class code2 {
    public static void main(String[] args) {
        //给你一个长度为 n 的数组 nums 和一个整数 m 。请你判断能否执行一系列操作，将数组拆分成 n 个 非空 数组。
        //
        //在每一步操作中，你可以选择一个 长度至少为 2 的现有数组（之前步骤的结果） 并将其拆分成 2 个子数组，而得到的 每个 子数组，至少 需要满足以下条件之一：

        //子数组的长度为 1 ，或者
        //子数组元素之和 大于或等于  m 。

        //如果你可以将给定数组拆分成 n 个满足要求的数组，返回 true ；否则，返回 false 。
        //注意：子数组是数组中的一个连续非空元素序列。
        //示例 1：
        //
        //输入：nums = [2, 2, 1], m = 4
        //输出：true
        //解释：
        //第 1 步，将数组 nums 拆分成 [2, 2] 和 [1] 。
        //第 2 步，将数组 [2, 2] 拆分成 [2] 和 [2] 。
        //因此，答案为 true 。
        //示例 2：
        //
        //输入：nums = [2, 1, 3], m = 5
        //输出：false
        //解释：
        //存在两种不同的拆分方法：
        //第 1 种，将数组 nums 拆分成 [2, 1] 和 [3] 。
        //第 2 种，将数组 nums 拆分成 [2] 和 [1, 3] 。
        //然而，这两种方法都不满足题意。因此，答案为 false 。
        //示例 3：
        //
        //输入：nums = [2, 3, 3, 2, 3], m = 6
        //输出：true
        //解释：
        //第 1 步，将数组 nums 拆分成 [2, 3, 4, 5] 和 [3] 。
        //第 2 步，将数组 [2, 3, 3, 2] 拆分成 [2, 3, 3] 和 [2] 。
        //第 3 步，将数组 [2, 3, 3] 拆分成 [2] 和 [3, 3] 。
        //第 4 步，将数组 [3, 3] 拆分成 [3] 和 [3] 。
        //因此，答案为 true 。
        //提示：
        //1 <= n == nums.length <= 100
        //1 <= nums[i] <= 100
        //1 <= m <= 200
        List<Integer> nums=new ArrayList<>();
        nums.add(1);nums.add(1);nums.add(2);nums.add(2);nums.add(1);
        System.out.println(canSplitArray(nums, 5));


    }
    //gg,又没写出来
    public static boolean canSplitArray(List<Integer> nums, int m) {
        int r=nums.size()-1;
        int sum=0;
        int number=0;
        for (Integer num : nums) {
            sum += num;
        }
        while (r!=0&&number<=nums.size()){
            if (nums.size()==2&&number+2>=nums.size())return true;
            if (sum-nums.get(0)>=m){
                sum-=nums.get(0);
                nums.remove(0);
                r--;
                number+=1;
            } else if (sum- nums.get(r)>=m) {
                sum -= nums.get(r);
                nums.remove(r);
                r--;
                number+=1;
            }else return false;
        }
        return true;
    }
}
