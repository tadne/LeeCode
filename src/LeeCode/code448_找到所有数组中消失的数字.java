package LeeCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code448_找到所有数组中消失的数字 {
    public static void main(String[] args) {
        //给你一个含 n 个整数的数组 nums ，
        // 其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
    }

    //原地修改
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n=nums.length;
        for (int num : nums) {
            int x = (num-1)%n;//取余数获取原来的值
            nums[x]+=n;//标记x位置出现过该数字
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=n) res.add(i);
        }
        return res;
    }



    //使用哈希表
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) res.add(i);
        }
        return res;
    }
}
