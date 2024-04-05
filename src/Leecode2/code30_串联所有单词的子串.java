package Leecode2;

import java.util.*;

public class code30_串联所有单词的子串 {
    public static void main(String[] args) {
        //给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
        //
        // s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
        //
        //例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。
        // "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
        //返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
        //words[i] 和 s 由小写英文字母组成
        System.out.println(findSubstring("abcdtheabcdef", new String[]{"ab","cd","ef"}));
    }

    //滑动窗口
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int wordLen = words[0].length();
        int num = words.length;
        // i<wordLen: 对于一个s=“barfoothefoobarman”，有wordLen种情况出现串联子串，分别是i从0-wordLen作为开始
        for (int i = 0;  i<wordLen ; i++) {
            //如果i后面的长度不足以出现串联子串
            if (i > sLen-num*wordLen ) break;

            //表示 串联子串下的单词频次 与 当前串下的单词频次 的差
            Map<String, Integer> diff = new HashMap<>();
            for (String word : words) {//添加理想状态下单词频次
                diff.put(word, diff.getOrDefault(word, 0) + 1);
            }
            for (int j = 0; j < num; j++) {//删除当前串下单词频次
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                diff.put(word, diff.getOrDefault(word, 0) - 1);
                if (diff.get(word) == 0) diff.remove(word);
            }

            // 滑动窗口
            for (int strat = i; strat < sLen-num*wordLen+1; strat += wordLen) {
                // 当start=i时，不移动窗口，只需要判断 单词频次差 是否为‘0’
                if (strat>i) {
                    //右边添加
                    String word = s.substring(strat +(num-1) * wordLen, strat + num  * wordLen);
                    diff.put(word,diff.getOrDefault(word,0)-1);
                    if (diff.get(word)==0) diff.remove(word);
                    //左边删除
                    word = s.substring(strat-wordLen,strat);
                    diff.put(word,diff.getOrDefault(word,0)+1);
                    if (diff.get(word)==0) diff.remove(word);
                }
                //如果 单词频次差 为 ‘0’,说明找到对应串联子串了
                if (diff.isEmpty()) res.add(strat);
            }
        }
        return res;
    }
}
