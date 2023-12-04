package LeeCode;


import Util.TreeNodeUtil;
import Util.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class code257_二叉树的所有路径 {
    public static void main(String[] args) {
        //给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
        //
        //叶子节点 是指没有子节点的节点。
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8);
        Util.TreeNode treeNode = TreeNodeUtil.generateTreeNodeByArray(list);
        System.out.println(binaryTreePaths(treeNode));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        trackBack(root,new StringBuilder(),res);
        return res;
    }
    public static void  trackBack(TreeNode root,StringBuilder sb,List<String> res) {
        if (root==null) return;
        int originalLength = sb.length();//维护长度
        if (root.left==null&&root.right==null){
            sb.append(root.val);
            res.add(sb.toString());
            sb.setLength(originalLength);//删除新增
            return;
        }
        sb.append(root.val).append("->");
        trackBack(root.left,sb,res);
        trackBack(root.right,sb,res);
        sb.setLength(originalLength);//删除新增
    }
}
