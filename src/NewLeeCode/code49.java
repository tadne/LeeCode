package NewLeeCode;

import java.util.*;

public class code49 {
    public static void main(String[] args) {
       //给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
        //
        //字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();//用map保证键不能重复
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);                 //排序
            String key = new String(array);     //以排序后的单词为键
            List<String> list = map.getOrDefault(key, new ArrayList<>());//如果没有获取对应key,那就创建新集合添加
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }




}
