package LeeCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

public class code136_只出现一次的数字 {
    public static void main(String[] args) {
        //给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
        //
        //你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
        int []arr={2,2,1};
        System.out.println(singleNumber1(arr));
    }
    public static int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) set.remove(num);
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
    //任何数和 0 做异或运算，结果仍然是原来的数，
    //任何数和其自身做异或运算，结果是 0
    //异或运算满足交换律和结合律，即 a^b=b^a   a^b^c=a^(b^c)
    //所以 a^b^c^d...可交换,也就是最终可以交换为: a^a^b^b^c^c^d...
    //也就是说: =0^0^..^0^n :n就是那个唯一数
    public static int singleNumber1(int[] nums) {
        int res=0;
        for (int num : nums) {
            res^=num;
        }
        return res;
    }
}
