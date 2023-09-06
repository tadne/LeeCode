package NewLeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code47 {
    public static void main(String[] args) {

        //给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
        int[]nums={1,1,2};
          System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();//结果集
        List<Integer> list = new ArrayList<Integer>();//结果
        boolean[] vis = new boolean[nums.length];//记录循环数据给后面使用
        Arrays.sort(nums);//排序
        backtrack(nums, res,  list,vis);//回溯
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list,boolean[] vis) {
        if (list.size() == nums.length) {//如果找到对应结果
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //如果当前索引第一次排这个位置
            // 或者(前一项和后一项相同 且前一项不是第一次排这个位置)
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            vis[i] = true;//当前索引元素第一次排这个位置,设为true
            backtrack(nums, res, list , vis);
            vis[i] = false;//第一次排完设为false
            list.remove(list.size()-1);
        }
        //这个题和前一个题不一样的地方
        //主要是两个地方,一个是判断,就是在26行,多了一个判断
        //第二就是vis数组是先true再false,就是在第一次排这个位置的时候,让这个位置的元素可以重复出现,然后第二次直接禁止这个位置的重复

    }



}
