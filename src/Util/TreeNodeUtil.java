package Util;

import LeeCode.code107_二叉树的层序遍历II;

import java.util.*;

public class TreeNodeUtil {

    public static void main(String[] args) {
//        (37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8);
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,37,-34,-48,null,-100,-100,48);
        TreeNode treeNode = generateTreeNodeByArray(list);
    }

    //利用数组生成树,采用层序
    public static TreeNode generateTreeNodeByArray(List<Integer> list){
        if (list==null||list.size()==0) return null;
        Queue<TreeNode> rows=new ArrayDeque<>();
        TreeNode root=new TreeNode(list.get(0));
        rows.add(root);
        int i=1;
        while (!rows.isEmpty()&&i<list.size()){
            TreeNode poll = rows.poll();
            poll.left= list.get(i)==null? null:new TreeNode(list.get(i));
            i++;
            poll.right= list.get(i)==null? null:new TreeNode(list.get(i));
            i++;
            if (poll.left!=null)rows.add(poll.left);
            if (poll.right!=null)rows.add(poll.right);
        }
        return root;
    }

    public static TreeNode generateTreeNodeByArray(int[] arr){
        List<Integer> list=new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return generateTreeNodeByArray(list);
    }
    public static TreeNode generateTreeNodeByArray(Integer[] arr){
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        return generateTreeNodeByArray(list);
    }


    //查看树的层结构
    public static void seeTreeNodeByLevel( TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();//结果集
        seeTreeNodeByLevel(root,res,1);//递归遍历二叉树
        System.out.println(res);
    }
    //递归加入元素
    private static void seeTreeNodeByLevel( TreeNode root, List<List<Integer>> res, int level) {
        if (root==null) return;//递归停止条件
        if (res.size()<level) res.add(null);//如果还没有对应集合,那就传个null留给后面创建
        if (res.get(level-1)==null){//如果是null,就创建对应集合并添加元素即可
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.set(level-1,list);
        }else res.get(level-1).add(root.val);//存在就直接添加元素
        seeTreeNodeByLevel(root.left,res,level+1);
        seeTreeNodeByLevel(root.right,res,level+1);
    }
}
