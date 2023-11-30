package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code216_组合总和III {
    public static void main(String[] args) {
        //找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
        //
        //只使用数字1到9
        //每个数字 最多使用一次
        //返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
        //2 <= k <= 9
        //1 <= n <= 60
        System.out.println(combinationSum3(3, 9));
    }
    //回溯法
    public static List<List<Integer>> combinationSum3(int k, int n) {
        //准备参数
        int[]arr={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        //回溯
        trackBack(res,list,arr,0,k,n,0);
        return res;
    }
    public static void trackBack(List<List<Integer>> res,List<Integer> list,int[]arr,int idx,int k, int n,int sum){
        if (list.size()==k){//如果list集合满了
            if (sum==n) res.add(new ArrayList<>(list));//符合条件
            return;
        }else if (sum>n){//因为arr递增,使用sum>n时剪枝
            return;
        }else if (idx==9){//如果遍历完毕
            return;
        }
        //开始添加值推动回溯
        list.add(arr[idx]);
        sum+=arr[idx];
        trackBack(res,list,arr,idx+1,k,n,sum);
        //进行回溯
        list.remove(list.size()-1);
        sum-=arr[idx];
        trackBack(res,list,arr,idx+1,k,n,sum);
    }



}
