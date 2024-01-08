package LeeCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code402_移除k位数字 {
    public static void main(String[] args) {
        //给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
        //
        //
        System.out.println(removeKdigits("1022", 2));
    }
    //其实就是删除前k个逆序的数字
    //这里采用暴力破解,O(n^2)
    public static String removeKdigits(String num, int k) {
        List<Character> list=new ArrayList<>();//集合处理,方便删除
        char[] chars = num.toCharArray();
        int zeroCount=0;//记录0的数量
        for (char aChar : chars) {
            list.add(aChar);
            if (aChar=='0') zeroCount++;
        }
        int n=list.size();
        int len=n-k;
        if (zeroCount>len) return "0";//如果o的数量大于结果集长度
        for (int i = 0; i < n-1&&k>0; i++) {
            if (list.get(i)>list.get(i+1)) {//找到逆序数字删除
                list.remove(i);
                k--;n--;i=-1;//k表示要删除的数量,n是集合长度,i=-1保证重新遍历
            }
        }
        StringBuilder res=new StringBuilder();
        for (Character c : list) {
            if (res.length()==len) break;//到达长度就停止
            if (res.length()>0||c!='0') res.append(c);//如果没有前导0
            else if (res.length() == 0) len--;//有前导0就减小结果长度
        }
        if (res.length()==0) return "0";
        return res.toString();

    }


}
