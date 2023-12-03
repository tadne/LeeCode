package LeeCode;

public class code235_二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
        //
        //最近公共祖先为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    }
    TreeNode ans;


    //自上而下,采用前序遍历,主要是先对root节点进行判断
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs1(root,p,q);
        return ans;
    }
    //找pq节点在哪个子树
    public boolean dfs1(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return false;
        boolean lson= p.val <= root.val || q.val <= root.val;
        boolean rson= p.val >= root.val || q.val >= root.val;
        if (lson&&rson){
            ans=root;
            return true;
        }else if (lson){
           return dfs1(root.left,p,q);
        }else return dfs1(root.right,p,q);
    }





    //自下而上,但其实这种方法更适合普通二叉树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
    public  boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson&&rson) || ((p.val==root.val||q.val==root.val)&&(lson||rson))){
            //如果 左右都存在, 或者一个在root,一个在左右树中
            ans=root;
        }
        return p.val==root.val||q.val==root.val||lson||rson;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
