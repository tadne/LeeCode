package Leecode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code207_课程表 {
    public static void main(String[] args) {
        //你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
        //
        //在选修某些课程之前需要一些先修课程。
        // 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
        //
        //例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
        //请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
    }
    //深度搜索

    List<List<Integer>> edges;  //存储有向图
    int[] visited;              //标记节点状态来判断环，0：未搜索，1：搜索中，2：搜索完毕
    boolean valid = true;       //是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存储有向图
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        //深度优先搜索，从课程0开始
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) dfs(i);
        }
        return valid;
    }
    public void dfs(int u) {
        visited[u] = 1;//搜索中
        //遍历u节点的所有方向
        for (int v: edges.get(u)) {
            //如果没有搜索过
            if (visited[v] == 0) {
                dfs(v);//向下搜索
                if (!valid) return;//有环
            } else if (visited[v] == 1) {//遇到搜索中的节点，即环
                valid = false;
                return;
            }
        }
        visited[u] = 2;//标记状态为：搜索完毕
    }
}
