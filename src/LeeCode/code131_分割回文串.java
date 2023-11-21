package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code131_分割回文串 {
    public static void main(String[] args) {
        //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
        //
        //回文串 是正着读和反着读都一样的字符串。
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        //准备回溯参数
        int len=s.length();
        List<List<String>> res=new ArrayList<>();//结果集
        if (len==0) return res;
        List<String> list=new ArrayList<>();
        char[] chars = s.toCharArray();
        trackBack(res,list,chars,len,0);
        return res;
    }
    //回溯
    public static void trackBack(List<List<String>> res,List<String> list,char[] chars,int len,int idx){
        if (list.size()==len){//递归结束条件
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < len; i++) {//遍历
            if (!checkPalindrome(chars,idx,i)) continue;//如果不是回文串就跳过
            list.add(new String(chars,idx,i-idx+1));//添加回文字符串
            trackBack(res,list,chars,len,i+1);//继续下一轮递归
            list.remove(list.size()-1);//进行回溯
        }
    }
    //判断是否是回文串
    private static boolean checkPalindrome(char[] charArray, int l, int r) {
        while (l < r) {
            if (charArray[l] != charArray[r]) return false;
            l++;r--;
        }
        return true;
    }
}
