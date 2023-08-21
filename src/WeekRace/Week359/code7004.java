package WeekRace.Week359;

import java.util.List;

public class code7004 {
    public static void main(String[] args) {
        //给你一个字符串数组 words 和一个字符串 s ，请你判断 s 是不是 words 的 首字母缩略词 。
        //
        //如果可以按顺序串联 words 中每个字符串的第一个字符形成字符串 s ，则认为 s 是 words 的首字母缩略词。例如，"ab" 可以由 ["apple", "banana"] 形成，但是无法从 ["bear", "aardvark"] 形成。
        //
        //如果 s 是 words 的首字母缩略词，返回 true ；否则，返回 false 。
    }
    public boolean isAcronym(List<String> words, String s) {
        if (s.length()!=words.size()) return false;
        for (int i = 0; i < words.size(); i++) {
            if (!words.get(i).substring(0,1).equals(s.substring(i,i+1))) return false;
        }
        return true;
    }
}
