package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code39_组合总和 {
    public static void main(String[] args) {
        //  给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target，找出 candidates 中可以使数字和为目标数 target
        //  所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
        //  candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
        //  对于给定的输入，保证和为target 的不同组合数少于 150 个。
       int[] aaa={8,7,4,3};
       int tar=11;

        combinationSum(aaa,tar);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        find(lists,list,target,candidates, 0);
        return lists;
    }

    public static void find( List<List<Integer>> lists,List<Integer> list, int target,int[] candidates,int index){
        if (candidates.length==index){//如果搜索完毕，就停
            return;
        }
        if (target==0){//如果找到一个结果，就停
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        int candidate = candidates[index];
        if (target>candidate) find(lists,list,target,candidates,index+1);//跳过当前位置寻找,所以tar不变,只修改idx
        if (target>=candidate){//实际回溯的位置
            list.add(candidate);
            find(lists,list,target-candidate,candidates,index);//实际寻找的位置,要记录tar的变化.但是不需要修改idx,因为当前位置可以重复添加
            list.remove(list.size()-1);
        }
    }


}
