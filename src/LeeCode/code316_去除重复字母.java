package LeeCode;


public class code316_去除重复字母 {
    public static void main(String[] args) {
        //给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
    }
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] arr = new int[26];
        for (char c : chars) arr[c - 'a']++; // 统计字母出现次数
        StringBuilder res = new StringBuilder(26);
        boolean[] inAns = new boolean[26];//判断字符是否以及在结果集合中了
        for (char cur : chars) {
            arr[cur - 'a']--;//将出现次数减1
            if (inAns[cur - 'a']) continue;//已经在结果集中
            //res的最后一个字符代表着当前字符是否满足字典序最小,题目还要求不能重复
            //也就是说,只要满足了 (当前字符比结果集的最后一个字符小,并且结果集的最后一个字符是重复的) 那么(就可以将它删除,再让当前字符加入结果集合)
            while (!res.isEmpty() && cur < res.charAt(res.length() - 1) && arr[res.charAt(res.length() - 1) - 'a'] > 0) {
                inAns[res.charAt(res.length() - 1) - 'a'] = false; // 标记 x 不在 res 中
                res.deleteCharAt(res.length() - 1);//删除最后一个字符
            }
            res.append(cur); // 把 当前字符 加到 res 的末尾
            inAns[cur - 'a'] = true; // 标记 c 在 res 中
        }
        return res.toString();
    }

}
