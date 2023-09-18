package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code40 {

    public static void main(String[] args) {
        //给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
        //
        //candidates中的每个数字在每个组合中只能使用一次。
        //
        //注意：解集不能包含重复的组合。
        //

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();//结果集
        Arrays.sort(candidates);//排序
        List<Integer> list = new ArrayList<>();//结果元素
        backtrack(lists,list,candidates,target,0,0);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists ,List<Integer> list,int[] candidates,int target,int sum,int begin) {
        if(sum == 0) {//如果找到了
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {//遍历数组
            if( i > begin && candidates[i] == candidates[i-1] ) continue;//如果当前位置元素重复并且当前元素不是第一个元素就跳过
            int newSum = sum+candidates[i] ;
            if(newSum <= target) {
                list.add(candidates[i]);
                backtrack(lists,list,candidates,target,newSum,i+1);//回溯
                list.remove(list.size()-1);//清除状态
            } else {
                break;
            }
        }
    }

}
