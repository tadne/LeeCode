package LeeCode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class code3 {
    public static void main(String[] args) {
        //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
        String s="cdd";
        System.out.println(lengthOfLongestSubstring(s));
    }
    //滑动窗口,就是可以O(n)解决问题,速度快
    //当遇到重复,记录这个重复元素的位置,继续向后遍历,计算长度的时候直接加上前
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;//标记左边重复元素的后面一个元素的位置,也可以理解为左边不符合条件元素的长度,比如:    fabcdea  :当扫描到重复时,left就是1,代表了"fa"的长度
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);//有重复了,刷新left的位置
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);//i就是当前位置,i+1就是当前长度,left就是左边不符合条件的元素的长度
        }
        return max;
    }
    public static int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            boolean b = map.containsKey(c);
            if (b){
                max=Math.max(max,map.size());
                i= map.get(c);
                map.clear();
            }else map.put(c,i);
        }
        max=Math.max(max,map.size());
        return max;
    }
    //这是比较慢的方式了,用contain方法速度很慢
    public static int lengthOfLongestSubstring1(String s) {
        List<Character> list=new ArrayList<>();
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (list.contains(c)) {
                int size = list.size();
                i=i-(size-list.indexOf(c));
                max=Math.max(max,size);
                list.clear();
            }else{
                list.add(c);
            }
        }
        max=Math.max(list.size(),max);
        return max;
    }
}
