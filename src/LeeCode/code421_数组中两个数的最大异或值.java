package LeeCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class code421_数组中两个数的最大异或值 {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
    // 1+1=0
    // 1+0=1
    public static int findMaximumXOR(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int high = 31 - Integer.numberOfLeadingZeros(max);//获取最大值的前置1的位置

        int ans = 0, mask = 0;
        Set<Integer> seen = new HashSet<>();//哈希表，用来保存重复的是0还是1的
        for (int i = high; i >= 0; i--) { // 从最高位开始枚举
            seen.clear();
            mask |= 1 << i;
            int newAns = ans | (1 << i); // newAns让ans的第i位为1，保存可以为1的位
            for (int x : nums) {
                x &= mask; // 低于 i 的比特位置设置为 0，以及 高于i的位中之前验证的不可能为1的位设置为0
                if (seen.contains(newAns ^ x)) {//如果集合中存在说明这个比特位可以为1，因为mask保证了x高于i的位一定是满足之前位的条件
                    ans = newAns; // 这个比特位可以是 1
                    break;
                }
                seen.add(x);
            }
        }
        return ans;

//        作者：灵茶山艾府
//        链接：https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/solutions/2511644/tu-jie-jian-ji-gao-xiao-yi-tu-miao-dong-1427d/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }
}
