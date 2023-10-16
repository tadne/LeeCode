package LeeCode;

import java.util.*;

public class code399_除法求值 {
    public static void main(String[] args) {
        //  给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
        // 其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
        //
        //另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
        //
        //返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
        //
        //注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
        //注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
        //1 <= equations.length <= 20
        //equations[i].length == 2
        //1 <= Ai.length, Bi.length <= 5
        //values.length == equations.length
        //0.0 < values[i] <= 20.0
        //1 <= queries.length <= 20
        //queries[i].length == 2
        //1 <= Cj.length, Dj.length <= 5
        //Ai, Bi, Cj, Dj 由小写英文字母与数字组成
    }
    //这个题我是真头疼,杀了我吧



//    作者：kknotchill
//    链接：https://leetcode.cn/problems/evaluate-division/solutions/2320470/javagraphhashmap-dfs-si-lu-qing-xi-jian-vwy2q/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //初始化Graph(以HashMap形式)
        Map<String, List<Cell>> graph = new HashMap<>();
        //对于每个Equation和其结果答案，将其加入Graph中
        for(int i = 0; i < values.length; i++) {
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);
            graph.computeIfAbsent(s1, k -> new ArrayList<>()).add(new Cell(s2, values[i]));
            graph.computeIfAbsent(s2, k -> new ArrayList<>()).add(new Cell(s1, 1.0 / values[i]));
        }
        //创建答案result数组以及访问过的HashSet: visited
        double[] res = new double[queries.size()];
        //首先将答案中所有答案值置为-1.0，出现(x / x)情况可以直接不用修改
        Arrays.fill(res, -1.0);
        //对于每个query中的值调用dfs函数
        for(int i = 0; i < queries.size(); i++) {
            dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, graph, res, i, new HashSet<>());
        }
        return res;
    }

    //src: 当前位置; dst: 答案节点; cur: 当前计算值; graph: 之前建的图; res: 答案array; index: 当前遍历到第几个query; visited: 查重Set
    private void dfs(String src, String dst, double cur, Map<String, List<Cell>> graph, double[] res, int index, Set<String> visited) {
        //base case: 在visited中加入当前位置信息；如果加不了代表已经访问过，直接返回
        if(!visited.add(src)) return;
        //如果当前位置src = 答案节点dst，并且此节点在graph中(避免x/x的情况)，用当前计算值cur来填充答案res[index]
        if(src.equals(dst) && graph.containsKey(src)) {
            res[index] = cur;
            return;
        }
        //对于邻居节点，调用dfs函数
        for(Cell nei : graph.getOrDefault(src, new ArrayList<>())) {
            dfs(nei.str, dst, cur * nei.div, graph, res, index, visited);
        }
    }




//    作者：LeetCode
//    链接：https://leetcode.cn/problems/evaluate-division/solutions/548634/399-chu-fa-qiu-zhi-nan-du-zhong-deng-286-w45d/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // 关系式的推导请见「参考代码」下方的示意图
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}

class Cell {
    String str;
    double div;

    Cell(String str, double div) {
        this.str = str;
        this.div = div;
    }
}

