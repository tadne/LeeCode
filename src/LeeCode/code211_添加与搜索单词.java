package LeeCode;

import java.util.*;

public class code211_添加与搜索单词{
    public static void main(String[] args) {
        //请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
        //
        //实现词典类 WordDictionary ：
        //
        //WordDictionary() 初始化词典对象
        //void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
        //bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
    }

//       作者：力扣官方题解
//       链接：https://leetcode.cn/problems/design-add-and-search-words-data-structure/solutions/1053383/tian-jia-yu-sou-suo-dan-ci-shu-ju-jie-go-n4ud/
//       来源：力扣（LeetCode）
//       著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   private static class WordDictionary {
       private final Trie root;

       public WordDictionary() {
           root = new Trie();
       }

       public void addWord(String word) {
           root.insert(word);
       }

       public boolean search(String word) {
           return dfs(word, 0, root);
       }

       private boolean dfs(String word, int index, Trie node) {
           if (index == word.length()) return node.isEnd();
           char ch = word.charAt(index);
           if (Character.isLetter(ch)) {//如果是字母
               int childIndex = ch - 'a';
               Trie child = node.getChildren()[childIndex];
               return child != null && dfs(word, index + 1, child);//如果子节点列表非空并且存在子节点
           } else {//如果不是字母
               for (int i = 0; i < 26; i++) {//遍历26个字母
                   Trie child = node.getChildren()[i];//一个一个找子树
                   if (child != null && dfs(word, index + 1, child)) return true;//如果子节点列表非空且存在子节点
               }
           }
           return false;
       }

    }
    private static class Trie {
        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public Trie[] getChildren() {
            return children;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
