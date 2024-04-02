package Leecode2;

public class code392_判断子序列 {
    public static void main(String[] args) {
        //给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
        //字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
        //字符串由小写字母构成
        //进阶：
        //
        //如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
        System.out.println(isSubsequence("ahbgdc", "abc"));
    }
    //动态规划
    //dp[i][j]: t字符串的 i 位置后，j元素的位置
    //后序遍历
    public static boolean isSubsequence(String s, String t) {
        int m=t.length(),n=s.length();

        //dp[i][j] ： 表示 t 中位置 i 开始往后，字符j第一次出现的位置
        int[][] dp = new int[m + 1][26];
        //最后一行的新字符出现的位置是设置为 m，方便结束循环
        for (int i = 0; i < 26; i++) {
            dp[m][i] = m;
        }
        //后序遍历，因为如果 dp[i][j]!=i,那么有dp[i][j]=dp[i+1][j]. 这个式子就是说如果i位置不是j元素，那么j元素肯定在i位置之后
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    dp[i][j] = i;
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }
        int idx = 0;//指向t的指针
        for (int i = 0; i < n; i++) {
            if (dp[idx][s.charAt(i)-'a'] == m){//如果 idx 位置后的 s.charAt(i) 元素的位置是 m，说明i位置之后没有 s.charAt(i) 元素了
                return false;
            }
            idx = dp[idx][s.charAt(i)-'a']+1;//找到对应的s.charAt(i)元素的位置dp[idx][s.charAt(i)-'a']，将指针移动到它后面
        }
        return true;
    }
}
