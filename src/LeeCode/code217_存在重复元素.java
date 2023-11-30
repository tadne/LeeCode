package LeeCode;

import java.util.HashSet;
import java.util.Set;

public class code217_存在重复元素 {
    public static void main(String[] args) {
        //给一个整数数组 nums 。
        //如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) return true;
        }
        return false;
    }
}
