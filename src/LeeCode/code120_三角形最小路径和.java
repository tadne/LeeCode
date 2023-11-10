package LeeCode;

import java.util.List;
import java.util.Map;

public class code120_三角形最小路径和 {
    public static void main(String[] args) {
        //给定一个三角形 triangle ，找出自顶向下的最小路径和。
        //
        //每一步只能移动到下一行中相邻的结点上。
        // 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
        // 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
    }
    //递归解决,但是超时了,但其实我觉得应该是没问题的来着..,还是重复计算太多了
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle,0,0,0);
    }
    public int minimumTotal(List<List<Integer>> triangle,int row,int idx,int res) {
        if (row==triangle.size()) return res;
        res+=triangle.get(row).get(idx);
        return Math.min(minimumTotal(triangle,row+1,idx,res),minimumTotal(triangle,row+1,idx+1,res));
    }


    //由底向上的
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];// dp[j] 表示从第i行的第j个点往下到底边的最小路径和。
        for (int i = n - 1; i >= 0; i--) {//从底边向上
            for (int j = 0; j <= i; j++) {//遍历第i行
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

//    作者：Sweetiee 🍬
//    链接：https://leetcode.cn/problems/triangle/solutions/329394/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
