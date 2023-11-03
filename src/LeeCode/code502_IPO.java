package LeeCode;

import java.util.*;

public class code502_IPO {
    public static void main(String[] args) {
        //假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。
        // 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
        //
        //给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
        //
        //最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
        //
        //总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
        //
        //答案保证在 32 位有符号整数范围内。
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];//建立映射

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);//排序

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);//建立大根堆
        while (k-- >0) {
            while (curr < n && arr[curr][0] <= w) {//如果成本足够，满足边界，就加入堆
                pq.add(arr[curr++][1]);
            }
            if (pq.isEmpty()) break;
            w += pq.poll();//加钱
        }

        return w;

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/ipo/solutions/984750/ipo-by-leetcode-solution-89zm/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
