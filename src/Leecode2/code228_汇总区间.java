package Leecode2;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 6, 7}));
    }
    //双指针、数组、字符串
    public static List<String> summaryRanges(int[] nums) {
        int len=nums.length;
        if(len==1) return List.of(String.valueOf(nums[0]));
        List<String> res=new ArrayList<>();
        int l=0;
        for (int i = 1; i < len; i++) {
            //如果不连续，就添加上一段区间
            if (nums[i]>nums[i-1]+1){
                StringBuilder sb=new StringBuilder();
                sb.append(nums[l]);
                //区分上一段区间长度为1的情况
                if (i-1!=l) res.add(sb.append("->").append(nums[i-1]).toString());
                else res.add(sb.toString());
                l=i;
            }
            if (i==len-1){
                StringBuilder sb=new StringBuilder();
                sb.append(nums[l]);
                //区分上一段区间长度为1的情况
                if (i!=l) res.add(sb.append("->").append(nums[i]).toString());
                else res.add(sb.toString());
            }
        }
        return res;
    }
}
