package LeeCode;

import java.util.*;
import java.util.stream.Collectors;

public class code228_汇总区间 {
    public static void main(String[] args) {
        //给定一个  无重复元素 的 有序 整数数组 nums 。
        //
        //返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
        //
        //列表中的每个区间范围 [a,b] 应该按如下格式输出：
        //
        //"a->b" ，如果 a != b
        //"a" ，如果 a == b

        int[]nums=new int[]{0,1,2,4,5,7};
        //int[]nums=new int[]{0,7};
        //int[]nums=new int[]{0};
        System.out.println(summaryRanges(nums));

    }
    //朴素for循环遍历处理
    public static List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        int n=nums.length;
        if (n==1) return List.of(String.valueOf(nums[0]));
        for (int i = 0; i < n;i++) {
            if (i<n-1) {
                if (nums[i] != nums[i + 1] - 1) res.add("" + nums[i]);//后一个和前一个不顺序
                else {//如果顺序
                    int temp = i;
                    while (i < n - 1 && nums[i] == nums[i + 1] - 1) i++;//找到对应的所有顺序
                    StringBuilder sb=new StringBuilder();
                    res.add(sb.append(nums[temp]).append("->") .append( nums[i]).toString());
                }
            }else res.add(""+nums[i]);//如果是最后一个不顺序
        }
        return res;
    }









}
