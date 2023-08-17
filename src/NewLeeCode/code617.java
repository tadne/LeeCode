package NewLeeCode;

public class code617 {
    public static void main(String[] args) {
        //给你两棵二叉树： root1 和 root2 。
        //
        //想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
        // 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
        //
        //返回合并后的二叉树。
        //
        //注意: 合并过程必须从两个树的根节点开始。
        TreeNode root1=new TreeNode(1);
        root1.left=new TreeNode(3);
        root1.left.left=new TreeNode(5);
        root1.right=new TreeNode(2);
        TreeNode root2=new TreeNode(2);
        root2.left=new TreeNode(1);
        root2.left.right=new TreeNode(4);
        root2.right=new TreeNode(3);
        root2.right.right=new TreeNode(7);
        mergeTrees1(root1,root2);

    }
    //二叉树遍历,递归
    //优化思路,可以将res改成在root1原数据上修改,缩减空间
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null) return root2;//左空
        else if (root2==null) return root1;//右空
        TreeNode res=new TreeNode(root1.val+root2.val);
        res.left=mergeTrees(root1.left,root2.left);//合并左子树
        res.right=mergeTrees(root1.right,root2.right);//合并右子树
        return res;
    }



    //优化思路,但是失败了
    public static TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1==null) return root2;//左空
        else if (root2==null) return root1;//右空
        System.out.println(root1.val);
        root1.val+=root2.val;
        root1.left=mergeTrees1(root1.left,root2.left);//合并左子树
        root2.right=mergeTrees1(root1.right,root2.right);//合并右子树
        return root1;
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
