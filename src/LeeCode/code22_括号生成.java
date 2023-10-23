package LeeCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class code22_括号生成 {
    public static void main(String[] args) {
        //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        trackBack(res,new StringBuilder(),n,0,0);
        return res;
    }
    /**
     * @param res   结果集
     * @param sb    对结果括号操作
     * @param n     最终括号对数
     * @param left  左括号数量
     * @param right 右括号数量
     */
    public static void trackBack(List<String> res,StringBuilder sb,int n,int left,int right){
        if (sb.length()==2*n) {
            res.add(sb.toString());
            return;
        }
        if (left<n){//左括号数量要小于n个
            sb.append('(');
            trackBack(res,sb,n,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right<left){//右括号的数量要小于左括号数量
            sb.append(')');
            trackBack(res,sb,n,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
