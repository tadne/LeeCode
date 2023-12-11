package LeeCode;

import java.util.*;

public class code310_最小高度树 {
    public static void main(String[] args) {
        //树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
        //给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。
        // 给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
        //可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
        //
        //请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
        //
        //树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
        int[][]mat={
                {3, 0},{3,1},{3,2},{3,4},{5,4}
        };
        System.out.println(findMinHeightTrees(4, mat));

    }

    //最小高度树的高度为 floor(maxdist/2),且最小高度树的根节点一定存在其最长路径上。
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        List<Integer>[] adj = new List[n];//重新排列,方便查找
        //初始化
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        //无向图需要加入两个方向
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        //存储父节点来为找到最长路准备
        int[] parent = new int[n];
        Arrays.fill(parent, -1);//最终将让叶子节点指向-1
        /* 找到与节点 0 最远的节点 x */
        int x = findLongestNode(0, parent, adj);
        /* 找到与节点 x 最远的节点 y */
        int y = findLongestNode(x, parent, adj);
        /* 求出节点 x 到节点 y 的路径 */
        List<Integer> path = new ArrayList<>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }

        //找到最长路了,按照理论,最长路径的中间节点就是最小高度树的根节点,其中如果是最长路径是偶数就有两个最小高度树
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));//这个 -1 是处理索引从0开始
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    //寻找最远的那个节点,并对parent进行初始化
    public static int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[n];//标记节点已被查找
        queue.offer(u);//加入根节点
        visit[u] = true;//标记根节点
        int node = -1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            node = curr;
            for (int v : adj[curr]) {//逐层遍历
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = curr;//记录当前节点v的父节点cur
                    queue.offer(v);
                }
            }
        }
        return node;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/minimum-height-trees/solutions/1395249/zui-xiao-gao-du-shu-by-leetcode-solution-6v6f/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
