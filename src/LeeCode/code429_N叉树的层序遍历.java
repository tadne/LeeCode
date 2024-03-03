        package LeeCode;



import Util.Node;

import java.util.ArrayList;
import java.util.List;

public class code429_N叉树的层序遍历 {
    public static void main(String[] args) {
        //给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
        //
        //树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
        Node node=new Node(1,List.of(new Node(3),new Node(2),new Node(4)));
        Node node1 = node.children.get(0);
        node1.children=List.of(new Node(5),new Node(6));
        System.out.println(levelOrder(node));

    }
    //其实就是要做一个预储存，遍历当前行的时候要储存好下一行的元素
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Node> cur = List.of(root);//当前行
        while (!cur.isEmpty()) {
            List<Node> next = new ArrayList<>();//下一行
            List<Integer> row = new ArrayList<>(cur.size()); //返回数据行
            for (Node node : cur) {
                row.add(node.val);
                next.addAll(node.children);
            }
            res.add(row);
            cur = next;
        }
        return res;

    }


}
