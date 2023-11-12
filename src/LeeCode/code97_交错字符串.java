package LeeCode;

public class code97_交错字符串 {
    public static void main(String[] args) {
        //给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
        //两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
        //
        //s = s1 + s2 + ... + sn
        //t = t1 + t2 + ... + tm
        //|n - m| <= 1
        //交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
        //注意：a + b 意味着字符串 a 和 b 连接。
        String s1 = "c", s2 = "bca", s3 = "bcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
    //这个题目要注意的是,交错表示可能在另一个字符串使用完本字符串的字符后导致不匹配
    //可以使用动态规划做
    //s1的前i个元素和s2的前j个元素能交错成s3的前i+j的元素的前提是:
    // 情况一:     s1的第i个元素和s3的第i+j个元素相同 并且 s1的前i-1个元素和s2的前j个元素可以交错
    // 情况二:     s2的第j个元素和s3的第i+j个元素相同 并且 s2的前j-1个元素和s1的前i个元素可以交错
    // 这两种情况只要有一种成立就能说明可以交错
    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) return false;
        boolean[] f = new boolean[m + 1];//f[i]表示s2的前i个元素以及s1的前j个元素是否可以交错成为s3的前i+j个元素,这里j其实被隐藏了
        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);// 等号右边的 f[j]表示: s1前i-1个元素和s2前j个元素能否交错形成s3前i+j-1个元素
                if (j > 0) f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return f[m];
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/interleaving-string/solutions/335373/jiao-cuo-zi-fu-chuan-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

}
