package WeekRace.Week370;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class code100115 {
    public static void main(String[] args) {
        //一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。
        //
        //给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。
        // 对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。
        //
        //在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
        //
        //返回这场比赛中将会成为冠军的队伍。
        int[][]arr={
                {0,1},
                {0,0}};
        System.out.println(findChampion(arr));
    }
    //也就是所有  grid[i][j]
    public static int findChampion(int[][] grid) {
        int n=grid.length;
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                if (grid[i][j]==1) arr[j]=1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0) return i;
        }
        return -1;
    }
}
