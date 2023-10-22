package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code77_组合 {
    public static void main(String[] args) {
        //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
        //
        //你可以按 任何顺序 返回答案
        System.out.println(subsets(5, 2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int[] vis=new int[n+1];
        trackBack(n,k,res,list,vis,1);
        return res;
    }

    public static void trackBack(int n, int k,  List<List<Integer>> res, List<Integer> list, int[] vis ,int i){
       if (list.size()==k){
           res.add(new ArrayList<>(list));
           return;
       }
        if (list.size()+(n-i+1)<k) return;
        int temp=i;
        for ( ; i < n+1; i++) {
           if (list.size()>0&&list.get(list.size()-1)>=i) continue;
           if (i>n) return;
           vis[i]=1;
           list.add(i);
           trackBack(n,k,res,list,vis,temp+1);
           list.remove(list.size()-1);
           vis[i]=0;
        }
    }



    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine1(int n, int k) {
        dfs(1, n, k);
        return ans;
    }
    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) return;
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        dfs(cur + 1, n, k);// 考虑选择当前位置
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);// 考虑不选择当前位置   上一个值已经删除了，接下来要继续添加回溯
    }

    //比较简陋，但是就是说，思路比较好
    //就是  添加流程：  比如k=2，n=5：     res： null=>1=>12,2=>12,23,3=>12,23,34,4=>....
    //可以 用队列去除长度为k的集合,再用剪枝效率会更好
    public static List<List<Integer>> subsets(int n,int k) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());//size=1
        int idx=1;
        for (int i = 1; i < n+1; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));//让tmp为前一轮的元素并加上当前一个元素,即每一轮都是前一轮元加当前元
                if (tmp.size()==k) continue;
                tmp.add(i);
                res.add(tmp);
            }
        }
        return res.stream().filter(s -> s.size() == k).toList();
    }



}
