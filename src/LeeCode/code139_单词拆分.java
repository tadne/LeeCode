package LeeCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code139_单词拆分 {
    public static void main(String[] args) {
        //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
        //
        //注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
        //1 <= s.length <= 300
        //1 <= wordDict.length <= 1000
        //1 <= wordDict[i].length <= 20
        //s 和 wordDict[i] 仅由小写英文字母组成
        //wordDict 中的所有字符串 互不相同
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);//Set集合优化查询效率
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {//用i和j左右指针来不停在Set中查询
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {//如果上一个字符串合法,并且i位置字符串也存在
                    dp[i] = true;//设置i位置为true
                    break;//继续下一个
                }
            }
        }
        return dp[s.length()];

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/word-break/solutions/302471/dan-ci-chai-fen-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    //其实就是官解的简单优化
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);//Set集合优化查询效率
        int n = s.length();
        boolean[] f = new boolean[n + 1];//判断i位置是否存在单词能到达
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && !f[i]; j++) {//将对f[i]的判断提前
                String sub = s.substring(j - 1, i);//截取并遍历
                if (set.contains(sub)) f[i] = f[j - 1];
            }
        }
        return f[n];

//        作者：宫水三叶
//        链接：https://leetcode.cn/problems/word-break/solutions/1945055/by-ac_oier-gh00/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }
}
