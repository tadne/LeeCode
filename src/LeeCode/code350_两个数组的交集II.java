package LeeCode;

import java.util.*;

public class code350_两个数组的交集II {
    public static void main(String[] args) {
        //给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
        // 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
    }
    //哈希表
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums1) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> res=new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)){
                if (map.get(num)!=0) {
                    map.put(num, map.get(num) - 1);
                    res.add(num);
                }
            }
        }
        return res.stream().mapToInt(val -> val).toArray();
    }
}
