package LeeCode;

import java.util.*;

public class code3_无重复字符的最长子串 {
    public static void main(String[] args) {
        //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
        //s 由英文字母、数字、符号和空格组成
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring3(s));
    }



    //滑动窗口,就是可以O(n)解决问题,速度快
    //当遇到重复,记录这个重复元素的位置,继续向后遍历,计算长度的时候直接加上前
    public static int lengthOfLongestSubstring3(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
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

    //滑动窗口第一种方式
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character,Integer> map=new HashMap<>();//key: 字符 , val:出现次数
        char[] chars = s.toCharArray();
        int l=0;
        int res=0,len=0;
        for (char c : chars) {
            //维护次数和长度
            map.put(c, map.getOrDefault(c, 0) + 1);
            len++;
            if (map.get(c) > 1) {//如果出现重复
                res = Math.max(len - 1, res);
                int tmp = l;
                do {
                    map.put(chars[l], map.get(chars[l]) - 1);//把上一个重复元素以及之前的都删了
                } while (chars[l++] != c);
                len -= l - tmp;
            }
        }
        res=Math.max(len,res);
        return res;
    }

    //用map集合维护不重复连续字符
    //map集合的最大长度即是结果
    //时间复杂度: O(n^2)
    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map=new HashMap<>();// key:字符 val:字符的索引
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            boolean b = map.containsKey(c);
            if (b){
                max=Math.max(max,map.size());
                i= map.get(c);//刷新i的位置从上一个重复+1处开始
                map.clear();
            }else map.put(c,i);
        }
        max=Math.max(max,map.size());
        return max;
    }

}
