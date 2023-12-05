package LeeCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class code260_只出现一次的数字III {
    public static void main(String[] args) {
        //给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
        //
        //你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
        int [] arr=new int[]{1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber1(arr)));
    }
    //位运算
    //因为通过异或运算有  0=x^x , x^0=x
    // 并且异或运算满足交换律和结合律
    public static int[] singleNumber1(int[] nums) {
        // 得到两个唯一值 a和b 的异或运算结果, 即 a^b=c
        int c = 0;
        for (int num : nums) {
            c ^= num;
        }
        //接下来用 c&(-c) 取出c的二进制的最右边的1的位 记为 lsb
        int lsb = (c == Integer.MIN_VALUE ? c : c & (-c));
        //在这一位上,a和b不同,一个是0,一个是1
        //那么如果以此来分类,那么a和b就不会在同一类中,而其他的相同的数都将在同一类中
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/single-number-iii/solutions/587516/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leet-4i8e/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


    //哈希表处理
    public int[] singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                set.remove(num);
            }else set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
