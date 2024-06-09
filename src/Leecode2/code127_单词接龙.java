package Leecode2;

import java.util.*;

public class code127_单词接龙 {
    public static void main(String[] args) {
        //字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
        //
        //每一对相邻的单词只差一个字母。
        // 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
        //sk == endWord
        //给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
    }
    //广度优先搜索，按照层序遍历进行，对于每个节点都要去重复遍历寻找其子节点，复杂度高
    //有待实现的优化思路：双向广度优先搜索，将endWord看做另外一个起点，只要在搜索中找到了二者的交集就代表找到从beginWord到endWord的路

    Map<String,Integer> map=new HashMap<>();
    Queue<String> queue=new ArrayDeque<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean exist=false;
        for (String s : wordList) {
            if (s.equals(endWord)) {
                exist = true;
                break;
            }
        }
        if (!exist) return 0;
        map.put(beginWord,1);
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            String poll = queue.poll();
            for (String s : wordList) {
                if (getDifOfTwoStr(s,poll)&&!map.containsKey(s)){
                    if (s.equals(endWord)) return map.get(poll)+1;
                    map.put(s,map.get(poll)+1);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean getDifOfTwoStr(String s,String s1){
        if (s.length()!=s1.length()) return false;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=s1.charAt(i)) count++;
            if (count==2) return false;
        }
        return count==1;
    }

}
