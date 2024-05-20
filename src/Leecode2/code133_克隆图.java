package Leecode2;


import Util.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code133_克隆图 {
    public static void main(String[] args) {
        //给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
        //
        //图中的每个节点都包含它的值 val（int） 和其邻居的列表
    }

    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        //如果该节点已经clone过，直接返回记录的节点
        if (map.containsKey(node))return map.get(node);
        //如果新节点
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node,clone);
        for (Node child : node.children) {
            map.get(node).children.add(cloneGraph(child));
        }
        return clone;
    }
}
