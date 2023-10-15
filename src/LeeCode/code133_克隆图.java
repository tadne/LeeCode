package LeeCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code133_克隆图 {
    public static void main(String[] args) {
        //给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
        //图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
        //class Node {
        //    public int val;
        //    public List<Node> neighbors;
        //}
        //测试用例格式：
        //简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
        //邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
        //给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
        //12
        //34
        Node node1=new Node(1 ,new ArrayList<>());
        Node node2=new Node(2,new ArrayList<>());
        Node node3=new Node(3,new ArrayList<>());
        Node node4=new Node(4,new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node3.neighbors.add(node1);
        node3.neighbors.add(node4);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);
        Node node = cloneGraph(node1);

    }
    //这个题目测试用例有点太难搞了,难以debug
    private static final HashMap <Node, Node> visited = new HashMap <> ();
    public static Node cloneGraph(Node node) {
        if (node == null) return node;
        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) return visited.get(node);
        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // 哈希表存储
        visited.put(node, cloneNode);
        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/clone-graph/solutions/370663/ke-long-tu-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



    //没看懂自己哪里出了问题,反正Leecode的一个12个节点的用例过不去
//    public static Node cloneGraph1(Node node) {
//        if (node==null) return null;
//        HashMap<Integer, Node> map = new HashMap<>();
//        putGraphToMap(node,map);
//        HashMap<Integer, Node> map1 = new HashMap<>();
//        map.forEach((idx,node1)->{
//            Node tmp=new Node(idx);
//            map1.put(idx,tmp);
//        });
//        map.forEach((idx,node1)->{
//            Node node2 = map1.get(idx);
//            List<Node> list=new ArrayList<>();
//            node2.neighbors=list;
//            for (Node neighbor : node1.neighbors) {
//                list.add(map1.get(neighbor.val));
//            }
//        });
//        return map1.get(1);
//    }
//    public static void putGraphToMap(Node node,Map<Integer,Node> map){
//        map.put(1,node);
//        for (Node neighbor : node.neighbors) {
//            if (map.containsKey(neighbor.val)) continue;
//            map.put(neighbor.val,neighbor);
//            for (Node neighbor1 : neighbor.neighbors) {
//                if (map.containsKey(neighbor1.val)) continue;
//                map.put(neighbor1.val,neighbor1);
//            }
//        }
//    }

    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
