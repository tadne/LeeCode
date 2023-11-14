package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code90_子集II {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
        //
        //解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
        //
        //
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//排序为去重做准备
        //准备
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        //回溯
        trackBack(res,list,nums,0,true);
        return res;
    }
    public void trackBack(List<List<Integer>> res,List<Integer> list,int[] nums,int idx,boolean flag){
        if (idx==nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        //提前给flag设置false,测一测当前这个要添加的元素是不是重复元素
        trackBack(res,list,nums,idx+1,false);
        if (!flag&&idx>0&&nums[idx-1]==nums[idx]) return;

        //添加元素
        list.add(nums[idx]);

        //回溯实现子集枚举
        trackBack(res,list,nums,idx+1,true);
        list.remove(list.size()-1);
    }
}
