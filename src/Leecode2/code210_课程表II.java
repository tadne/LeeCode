package Leecode2;

import java.util.ArrayList;
import java.util.List;

public class code210_课程表II {
    public static void main(String[] args) {
        //现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
        //给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
        //例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
        //返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。
        //如果不可能完成所有课程，返回 一个空数组 。
    }
    //本题需要 保证图中无环 并且 找到满足条件的节点顺序
    //  环的寻找可以通过记录节点状态寻找
    //  节点顺序通过回溯法记录


    //有向图
    List<List<Integer>> edges;
    //节点状态记录
    int[] vis;
    //是否无环
    boolean validate=true;
    //结果集
    int[] res;
    //结果集指针
    int idx;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //初始化
        res=new int[numCourses];
        edges=new ArrayList<>();
        vis=new int[numCourses];
        idx=0;
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[0]).add(prerequisite[1]);
        }

        //开始递归，深度搜索+回溯
        for (int i = 0; i < numCourses&&validate; i++) {
            if (vis[i] == 0) dfs(i);
        }

        //返回
        if (!validate) return new int[0]; //如果有环就直接返回
        return res;
    }
    private void dfs(int i) {
        //标记节点状态为搜索中
        vis[i]=1;

        //向深处搜索
        for (Integer integer : edges.get(i)) {
            if (vis[integer]==1){//遇到环
                validate=false;
                return;
            }else if (vis[integer]==0){
                dfs(integer);//继续深度搜索
            }
        }

        //标记节点状态为搜索完毕
        vis[i]=2;
        //记录结果集
        res[idx++]=i;
    }


}
