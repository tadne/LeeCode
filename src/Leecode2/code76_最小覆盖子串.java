package Leecode2;

public class code76_最小覆盖子串 {
    public static void main(String[] args) {
       // 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    }
    //双指针、滑动窗口
    //
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        int sLen = ss.length;
        int l = -1,r = sLen;
        int left = 0;
        int less = 0;//维护目前子串中有 less 种字母的出现次数小于 ttt 中字母的出现次数
        int[] cntS = new int[128]; // s 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            if (cntT[c]++ == 0) {
                less++; // 有 less 种字母的出现次数 < t 中的字母出现次数
            }
        }
        for (int right = 0; right < sLen; right++) { // 移动子串右端点
            char c = ss[right]; // 右端点字母（移入子串）
            if (++cntS[c] == cntT[c]) {
                less--; // c 的出现次数从 < 变成 >=
            }
            while (less == 0) { // 涵盖：所有字母的出现次数都是 >=
                if (right - left < r - l) { // 找到更短的子串
                    l = left; // 记录此时的左右端点
                    r = right;
                }
                char x = ss[left++]; // 左端点字母（移出子串）
                if (cntS[x]-- == cntT[x]) {
                    less++; // x 的出现次数从 >= 变成 <
                }
            }
        }
        return l < 0 ? "" : s.substring(l, r + 1);
//        作者：灵茶山艾府
//        链接：https://leetcode.cn/problems/minimum-window-substring/solutions/2713911/liang-chong-fang-fa-cong-o52mn-dao-omnfu-3ezz/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
