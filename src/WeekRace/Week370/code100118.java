package WeekRace.Week370;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code100118 {
    public static void main(String[] args) {
        //有一棵 n 个节点的无向树，节点编号为 0 到 n - 1 ，根节点编号为 0 。
        // 给你一个长度为 n - 1 的二维整数数组 edges 表示这棵树，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。
        //
        //同时给你一个长度为 n 下标从 0 开始的整数数组 values ，其中 values[i] 表示第 i 个节点的值。
        //
        //一开始你的分数为 0 ，每次操作中，你将执行：
        //
        //选择节点 i 。
        //将 values[i] 加入你的分数。
        //将 values[i] 变为 0 。
        //如果从根节点出发，到任意叶子节点经过的路径上的节点值之和都不等于 0 ，那么我们称这棵树是 健康的 。
        //
        //你可以对这棵树执行任意次操作，但要求执行完所有操作以后树是 健康的 ，请你返回你可以获得的 最大分数 。
        //2 <= n <= 2 * 104
        //edges.length == n - 1
        //edges[i].length == 2
        //0 <= ai, bi < n
        //values.length == n
        //1 <= values[i] <= 109
        //输入保证 edges 构成一棵合法的树。
        int [][] arr={{0,1},{0,2},{0,3},{2,4},{4,5}};
        // 0->1,2,3     2->4->5
        // 01  0245  03
        // 12345
        int [] values={5,2,5,2,1,1};
        System.out.println(maximumScoreAfterOperations(arr, values));
    }
    //不小心写成每条路最大值求和了
    //这个题的题目,我觉得我有点不太能理解...
    public static long maximumScoreAfterOperations(int[][] edges, int[] values) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int[] edge : edges) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0], list);
            }
        }
        return maximumScoreAfterOperations(map,values,values[0],0);
    }
    public static long maximumScoreAfterOperations( Map<Integer, List<Integer>> map, int[] values,long res ,int i) {
       boolean b = map.containsKey(i);
       if (b){//不是叶子
           List<Integer> list = map.get(i);
           long num = 0;
           for (int j = 0; j < list.size(); j++) {
              num += maximumScoreAfterOperations(map,values,values[list.get(j)],list.get(j));
           }
           if (num>res) return num;
           else return res;
       }else return Math.max(res,values[i]);
    }
}
