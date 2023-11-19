package LeeCode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class code110_平衡二叉树 {
    public static void main(String[] args) {
        //给定一个二叉树，判断它是否是高度平衡的二叉树。
        //
        //本题中，一棵高度平衡二叉树定义为：
        //
        //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
        TreeNode node=new TreeNode(1);
        node.right=new TreeNode(1);
        node.left=new TreeNode(1);

        node.left.right=new TreeNode(1);
        node.left.left=new TreeNode(1);
        node.right.left=new TreeNode(1);

        node.left.left.left=new TreeNode(1);
        //      1
        //   1     1
        // 1  1  1
        //1
        System.out.println(isBalanced(node));
    }
    //如果采用自顶向下,那就需要不停计算左右子树的高度并比较
    //但是采用自底向上,那就只需要不断将左右子树中高度大的那个返回给父节点即可
    //对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
    public static boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;//如果深度差小于2,就返回深度,否则返回-1
    }
//    作者：Krahets
//    链接：https://leetcode.cn/problems/balanced-binary-tree/solutions/8737/balanced-binary-tree-di-gui-fang-fa-by-jin40789108/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


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
