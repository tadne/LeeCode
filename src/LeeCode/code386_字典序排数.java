package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code386_字典序排数 {
    public static void main(String[] args) {
        //给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
        //
        //你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
        System.out.println(lexicalOrder(99));
    }
    //深度搜索
    //整体类似遍历9叉树的中序遍历
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(n,res,i);
        }
        return res;
    }
    //按照最大位的数字进行分组
    public static void dfs(int n,List<Integer> res,int num){
        if (num<=n) res.add(num);
        else return;//递归结束条件
        for (int i = 0; i <= 9; i++) {
            dfs(n,res,num*10+i);//+i实现遍历所有子树
        }
    }

}
