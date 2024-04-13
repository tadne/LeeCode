package Leecode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class code128_最长连续序列 {
    public static void main(String[] args) {
        //给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
        //
        //请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
        //输入：nums = [100,4,200,1,3,2]
        //输出：4
        //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
        int[] arr={0,0,-1};
        System.out.println(longestConsecutive1(arr));
    }
    //其实这个题就是找最大连通图的大小
    
    //进一步优化，我们其实可以发现，其实可以不需要遍历查找所有元素的连续序列，只需要查找端点的连续序列即可
    public static int longestConsecutive3(int[] nums) {
        if (nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        int len=1;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            int sum=0;
            if (set.contains(--num)) continue;
            while (set.contains(++num)) sum++;
            len = Math.max(sum,len);
        }
        return len;
    }

    //暴力法的优化，采用set集合，然后遍历set集合来查找以当前元素为最大值的连续序列
    public static int longestConsecutive2(int[] nums) {
        if (nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        int len=1;
        int cur=-1;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            int sum=0;
            while (set.contains(--num)) sum++;
            len = Math.max(sum,len);
        }
        return len;
    }

    //暴力超时，就是每次遇到值都回溯找连续的+1序列
    public static int longestConsecutive1(int[] nums) {
        if (nums.length==0) return 0;
        Map<Integer,Integer> map=new HashMap<>();
        int len=1;
        int cur=-1;
        for (int num : nums) {
            map.put(num,1);
        }
        for (int num : map.keySet()) {
            while (map.containsKey(--num)) {
                map.put(num, map.get(num) + 1);
                len = Math.max(map.get(num), len);
            }
        }
        return len;
    }
}
