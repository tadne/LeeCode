package NewLeeCode;

import java.util.ArrayList;
import java.util.List;

public class code207 {
    public static void main(String[] args) {
        //你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
        //
        //在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
        //例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
        //请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
    }
    List<List<Integer>> edges;//存储有向图
    int[] visited;//检查状态判断环
    boolean valid = true;//是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存储有向图
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
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
    public void dfs(int u) {
        visited[u] = 1;//搜索中
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);//向下搜索
                if (!valid) return;//有环
            } else if (visited[v] == 1) {//遇到环
                valid = false;
                return;
            }
        }
        visited[u] = 2;//搜索完毕
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/course-schedule/solutions/359392/ke-cheng-biao-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
