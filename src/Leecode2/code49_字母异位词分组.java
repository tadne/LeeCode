package Leecode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code49_字母异位词分组 {
    public static void main(String[] args) {
        //给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
        //
        //字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
        String[] strs={"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            String anaStr = getAnaStr(str);
            if (map.containsKey(anaStr)){
                map.get(anaStr).add(str);
            }else {
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(anaStr,list);
            }
        }
        return new ArrayList<>(map.values());
    }
    public static String getAnaStr(String s){
        int[] arr=new int[26];
        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }
        StringBuilder res=new StringBuilder();
        for (int i : arr) {
            if (i>9){
                res.append((char) (i+'a'));
            }
        }
        return res.toString();
    }
}
