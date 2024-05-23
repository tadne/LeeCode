package Leecode2;

import java.util.*;

public class code399_除法求值 {
    public static void main(String[] args) {
        //给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
        // 其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
        //
        //另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
        //
        //返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
        //
        //注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
        //
        //注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
    }

    /**
     * 除法求值
     * @param equations 变量对
     * @param values 值
     * @param queries 目标变量对
     * @return 目标变量对的除法对应的值
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //初始化Graph(以HashMap形式):用来为每一个变量通过“除法”连接
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
    /**
     *
     * @param src 当前节点
     * @param dst 目标节点
     * @param cur 当前值
     * @param graph 图
     * @param res 结果集
     * @param index 结果集当前索引位
     * @param visited 避免重复
     */
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
}
class Cell {
    String str;
    double div;
    Cell(String str, double div) {
        this.str = str;
        this.div = div;
    }
}
