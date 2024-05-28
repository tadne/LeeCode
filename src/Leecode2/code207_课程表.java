package Leecode2;

import java.util.ArrayList;
import java.util.List;

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
    //深度搜索：判断图是否有环

    List<List<Integer>> edges;  //存储有向图
    int[] visited;              //标记节点状态来判断环，0：未搜索，1：搜索中，2：搜索完毕
    boolean valid = true;       //是否无环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存储有向图：可能有环
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        //深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) dfs(i);
        }
        return valid;
    }
    private void dfs(int i) {
        visited[i]=1;
        //处理下一层节点
        for (Integer integer : edges.get(i)) {
            if (visited[integer]==1){//如果该节点是处理中，表示遇到环了
                valid=false;
                return;
            }else if (visited[integer]==0){//如果该节点未处理，就进行递归
                dfs(integer);
            }
        }
        visited[i]=2;
    }


}
