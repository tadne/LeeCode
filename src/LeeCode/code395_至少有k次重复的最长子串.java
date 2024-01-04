package LeeCode;

import java.util.*;

public class code395_至少有k次重复的最长子串 {
    public static void main(String[] args) {
        //给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
        //如果不存在这样的子字符串，则返回 0。
        //1 <= s.length <= 10^4
        //s 仅由小写英文字母组成
    }
    //如果一个字符出现次数小于k,那说明这个字符不能出现在结果集合中
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;

        HashMap<Character, Integer> counter = new HashMap<>();// key: 字符 val:出现次数
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {//采用了split函数,按照在s中出现小于k次的字符分割
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();

//        作者：负雪明烛
//        链接：https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solutions/623991/jie-ben-ti-bang-zhu-da-jia-li-jie-di-gui-obla/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

}
