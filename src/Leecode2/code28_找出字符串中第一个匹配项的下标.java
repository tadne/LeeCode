package Leecode2;

public class code28_找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        //给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
        // 如果 needle 不是 haystack 的一部分，则返回  -1 。
        //
        //
        String s = "aaabbab";
        String p = "aaabbabaaabbabaaabbab";
        System.out.println(strStr1(s, p));
    }
    //字符串匹配：随着匹配的进行，原串指针右移，本质上是在不断地在否决一些「不可能」的方案，
    //      当原串指针从 i 后移 j，代表着否决了那些以「原串」下标范围为 [i,j) 为「匹配发起点」的子集。
    //KMP字符串匹配算法
    //  在匹配字符串时，如果出现字符不匹配，首先匹配串会检查之前已经匹配成功的部分中里是否存在相同的「前缀」和「后缀」
    //      如果存在，则跳转到「前缀」的下一个位置继续往下匹配：
    //
    //实现： 扫描完整原串这一操作不可避免，我们可以优化的只能是「检查已匹配部分的相同前缀和后缀」这一过程。
    //  对于匹配串的任意一个位置而言，该位置发起的下一个匹配点位置其实与原串无关：例如： abcabd 的d字符而言，它的下一个匹配点时c，因为它们的前缀都是ab
    //  next 数组：
    //      k=0:    next[k]=-1  当k为0时
    //      k>0:    next[k]=最长公共元素长度, 比如 aba的前缀有 a,ab. 后缀有 ba,a. 那公共元素就是a
    //

    /**
     * 采用KMP算法，查找字符串子串的位置
     *
     * @param source 源字符串
     * @param target 目标(子)字符串
     * @return 目标字符串在源字符串中第一次出现的索引位置
     */
    public int indexOfToKMP(String source, String target) {
        int i, j;
        // 调用接口中的方法，获取next数组
        int[] next = getNext(target);
        // 初始化遍历
        i = 0;j = 0;
        // 判断i和j的索引都不能大于等于字符串长度，否则说明比较完成
        while (i < source.length() && j < target.length()) {
            // 如果j==-1 或者 公共元素相等，继续比较
            if (j == -1 || source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                //按照数组回溯j
                j = next[j];
            }
        }
        // 判断子字符的索引是否大于等于子字符串，如果为true说明查找成功，返回源字符串当前位置-子字符串长度
        return j >= target.length() ? i - target.length() : -1;
    }
    public int[] getNext(String target) {
        // 初始化数组大小
        int[] next = new int[target.length()];
        // 0 位置默认为-1
        next[0] = -1;
        // 遍历字符串每一位，计算每个位置上的值
        for (int i = 0, k = -1; i < target.length() - 1; ) {
            //如果前后缀一致或者k回到最初位置
            if (k == -1 || target.charAt(i) == target.charAt(k)) {
                i++;k++;
                // 判断当前字符 和 k位置的字符是否相等
                if (target.charAt(i) == target.charAt(k)) {
                    // 若相等，则继承k位置的值
                    next[i] = next[k];
                } else {
                    // 不等，则还是使用原来next数组的值
                    next[i] = k;
                }
            } else {//否则回溯，
                k = next[k];
            }
        }
        return next;
    }



    //宫水三叶，KMP算法
    public static int strStr1(String ss, String pp) {
        if (pp.isEmpty()) return 0;
        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 如果
            while (j > 0 && p[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }
        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }
        return -1;
//        作者：宫水三叶
//        链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/575568/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
