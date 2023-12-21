package LeeCode;

import java.util.*;
import java.util.function.ToIntFunction;

public class code349_两个数组的交集I {
    public static void main(String[] args) {
        //给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
    }
    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer> set=new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        List<Integer> res=new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)){
                res.add(num);
                set.remove(num);
            }
        }
        return res.stream().mapToInt(val -> val).toArray();
    }

}
