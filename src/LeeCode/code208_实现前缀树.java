package LeeCode;

import java.util.*;

public class code208_实现前缀树 {
    public static void main(String[] args) {
        //Trie 前缀树:  一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
        //
        //请你实现 Trie 类：
        //
        //Trie() 初始化前缀树对象。
        //void insert(String word) 向前缀树中插入字符串 word 。
        //boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
        //boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
    }
    //其实根本没有使用字典树hhh,就用set强行过关
    private static class Trie {
        private static  Set<String> prefixSet ;
        private static Set<String> wordSet ;
        public Trie() {
            prefixSet=new HashSet<>();
            wordSet=new HashSet<>();
        }

        public void insert(String word) {
            if (wordSet.contains(word)) return;
            wordSet.add(word);
            for (int i = 1; i < word.length(); i++) {
                String substring = word.substring(0, i);
                prefixSet.add(substring);
            }
        }

        public boolean search(String word) {
            return wordSet.contains(word);
        }

        public boolean startsWith(String prefix) {
           return prefixSet.contains(prefix);
        }
    }
}
