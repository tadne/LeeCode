package LeeCode;

import java.util.*;

public class code423_从英文中重建数字 {
    public static void main(String[] args) {
        //给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
        System.out.println(originalDigits("owoztneoer"));
    }
    // one w three u five x seven g nine z
    // w u x g z  2 4 6 8 0
    // o r v s 1 3 5 7
    // n 9
    //其实就是有些单词的字母有唯一性,具有唯一性的单词去除后,又有单词的字母展露出唯一性
    static String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};
    public static String originalDigits(String s) {
        int n = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < n; i++) cnts[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            for (char c : ss[i].toCharArray()) k = Math.min(k, cnts[c - 'a']);//获取唯一标识的单词的数量
            for (char c : ss[i].toCharArray()) cnts[c - 'a'] -= k;//删除这些单词
            while (k-- > 0) sb.append(i);//添加这些数字
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);//排序返回
        return new String(cs);
    }

//    作者：宫水三叶
//    链接：https://leetcode.cn/problems/reconstruct-original-digits-from-english/solutions/1118849/gong-shui-san-xie-nao-jin-ji-zhuan-wan-m-vg7a/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
