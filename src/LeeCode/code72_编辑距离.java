package LeeCode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class code72_编辑距离 {
    public static void main(String[] args) {
        //给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
        //你可以对一个单词进行如下三种操作：
        //插入一个字符
        //删除一个字符
        //替换一个字符
    }
    //dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
    //所以，
    //当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
    //当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
    //
    //其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
    public int minDistance(String word1, String word2) {
        int n = word1.length(),m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        // 第一行
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {//开始填表
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n][m];
//        作者：powcai
//        链接：https://leetcode.cn/problems/edit-distance/solutions/1/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
