package LeeCode;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

public class code383_赎金信 {
    public static void main(String[] args) {
        //给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
        //
        //如果可以，返回 true ；否则返回 false 。
        //
        //magazine 中的每个字符只能在 ransomNote 中使用一次。
    }
    //直接数组储存,效率高
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/ransom-note/solutions/1135839/shu-jin-xin-by-leetcode-solution-ji8a/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
    //map集合储存,效率低
    public boolean canConstruct(String ransomNote, String magazine) {
        int m=ransomNote.length();
        int n=magazine.length();
        if (m>n) return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }
        for (int i = 0; i < m; ) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                i++;
                Integer integer = map.get(c);
                if (integer==1) map.remove(c);
                else map.put(c,map.get(c)-1);
            }else return false;
        }
        return true;
    }
}
