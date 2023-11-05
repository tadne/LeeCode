package WeekRace.Week370;

import java.util.HashSet;
import java.util.Set;

public class code100116 {
    public static void main(String[] args) {
        //一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。每支队伍也是 有向无环图（DAG） 上的一个节点。
        //
        //给你一个整数 n 和一个下标从 0 开始、长度为 m 的二维整数数组 edges 表示这个有向无环图，其中 edges[i] = [ui, vi] 表示图中存在一条从 ui 队到 vi 队的有向边。
        //
        //从 a 队到 b 队的有向边意味着 a 队比 b 队 强 ，也就是 b 队比 a 队 弱 。
        //
        //在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
        //
        //如果这场比赛存在 唯一 一个冠军，则返回将会成为冠军的队伍。否则，返回 -1 。
        int[][]arr=new int[][]{{0,1},{1,2}};
        int n=3;
        System.out.println(findChampion(n, arr));
    }
    public static int findChampion(int n, int[][] edges) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            set.add(edges[i][1]);
        }
        int size=set.size();
        if (size!=n-1) return -1;
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }
}
