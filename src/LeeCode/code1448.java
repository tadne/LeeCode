package LeeCode;

public class code1448 {
    public static void main(String[] args) {
        //给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
        //
        //「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
        TreeNode treeNode=new TreeNode(3);
        treeNode.left=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(2);
//        treeNode.right=new TreeNode(4);
//        treeNode.right.left=new TreeNode(1);
//        treeNode.right.right=new TreeNode(5);
        System.out.println(goodNodes(treeNode));
    }
    public static int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }
    public static int goodNodes(TreeNode root,int max){
        if (root==null) return 0;
        int res=0;
        if (root.val>=max) {
            res++;
            max= root.val;
        }
        res+=goodNodes(root.left,max)+goodNodes(root.right,max);
        return res;
    }


    //上下两个代码逻辑相同,但是在力扣上,下面这个就是跑不出来正确的值.在ide上是正确的.有点无语的
    //难道力扣是不允许用静态全局变量?没明白反正
    static int count=0;
    public static int goodNodes1(TreeNode root) {
        goodNodes1(root, root.val);
        return count;
    }
    public static void goodNodes1(TreeNode root,int max){
        if (root==null) return;
        if (root.val>=max) {
            count++;
            max= root.val;
        }
        goodNodes1(root.left,max);
        goodNodes1(root.right,max);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
