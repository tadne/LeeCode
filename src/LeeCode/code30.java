package LeeCode;

import java.util.*;

public class code30 {
    public static void main(String[] args) {
        //给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
        //
        // s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
        //
        //例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"，
        // 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
        //返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案
        String s="barfoothefoobarman";
        String[] words={"bar","foo"};
        System.out.println(findSubstring(s, words));;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words/solutions/1616997/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-244a/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //官解加注释,自己想这种题目还是太花时间了
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 所有单词的个数
        int num = words.length;
        // 每个单词的长度（是相同的）
        int wordLen = words[0].length();
        // 字符串长度
        int stringLen = s.length();
        for (int i = 0; i < wordLen; i++) {
            // 遍历的长度超过了整个字符串的长度，退出循环
            if (i + num * wordLen > stringLen) break;
            // differ表示 窗口中的单词频次 和 words中的单词频次之差
            Map<String, Integer> differ = new HashMap<>();
            // 初始化窗口，窗口长度为num * wordLen, 依次计算窗口里每个切分的单词的频次
            for (int j = 0; j < num; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);//获取窗口中的word
                differ.put(word, differ.getOrDefault(word, 0) + 1);//计算窗口中word出现的次数
            }
            // 遍历words中的word，对窗口里每个单词计算差值
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                // 差值为0时，移除掉这个word
                if (differ.get(word) == 0) differ.remove(word);
            }
            // 开始滑动窗口
            for (int start = i; start < stringLen - num * wordLen + 1; start += wordLen) {//每次滑动一个单词的长度
                if (start != i) {
                    // 右边的单词滑进来
                    String word = s.substring(start + (num - 1) * wordLen, start + num * wordLen);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);//计算数量,如果
                    if (differ.get(word) == 0) differ.remove(word);

                    // 左边的单词滑出去
                    word = s.substring(start - wordLen, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);//如果上一轮是空匹配成功,那么这一轮滑出去的单词的计数会变成-1
                    if (differ.get(word) == 0) differ.remove(word);
                }

                // 窗口匹配的单词数等于words中对应的单词数
                if (differ.isEmpty()) res.add(start);
            }
        }
        return res;
    }
}
