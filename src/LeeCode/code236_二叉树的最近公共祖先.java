package LeeCode;

public class code236_二叉树的最近公共祖先 {
    public static void main(String[] args) {
        //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
        //
        //百度百科中最近公共祖先的定义为：
        // “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
        TreeNode node=new TreeNode(3);
        node.left=new TreeNode(5);
        node.right=new TreeNode(1);
        node.right.left=new TreeNode(0);
        node.right.right=new TreeNode(8);
        node.left.left=new TreeNode(6);
        node.left.right=new TreeNode(2);
        node.left.right.left=new TreeNode(7);
        node.left.right.right=new TreeNode(4);
//        System.out.println(getPathOfNode(node, node.left.right.right));
//        System.out.println(num);
        System.out.println(lowestCommonAncestor2(node,  node.left.left, node.right.left).val);
    }



    //这个方法速度比较慢,最坏情况是O(n^2) n是树的层数
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==p) return p;
        else if (root==q) return q;
        if (containNode(root.left,p)){//如果p在左边
            if (containNode(root.right,q)) return root;//q在右边
            else return lowestCommonAncestor(root.left,p,q);//q也在左边
        }
        //p在右边
        if (containNode(root.left,q)) return root;//q在左边
        else return lowestCommonAncestor(root.right,p,q);//q也在右边
    }
    public static boolean containNode(TreeNode root,TreeNode node){//判断node节点在不在root树中
        if (root==null) return false;
        if (root==node) return true;
        return containNode(root.left,node)||containNode(root.right,node);
    }




    //其实我的优化思路是用一个01字符串来记录节点的路径,然后比较路径找到节点的,我这个方法应该更快,可以去试试
    //但是看了官解后发现可以直接存父节点的方式找到
    //递归找到对应父节点
    //它其实是先到达树的底部,再往上找,其实我觉得效率也没有多高,但是是O(n)
    private static TreeNode ans;
    public  static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            //如果左右两边都找到了,或者(当前树根节点就是p或q 并且 另一个也被找到了)
            //其实就是p和q都找到了就记录当前根节点
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
   //作者：力扣官方题解
   //链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/238552/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
   //来源：力扣（LeetCode）
   //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



    //一开始想的是用一个位图来记录节点的路径
    //但是发现long型不够用了,再改太麻烦了
    //就先这样了
    //其实可以用String类型解决,也可以用数组解决...
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        getPathOfNode(root,p);
        long pathP=num;
        num=1;
        getPathOfNode(root,q);
        long pathQ=num;
        if (pathQ==1||pathP==1) return root;
        do {
            int pDir = (int) (pathP % 10);
            int qDir = (int) (pathQ % 10);
            if (pDir==qDir){
                if (pDir==1) root=root.right;
                else root=root.left;
            }else return root;
            pathP/=10;pathQ/=10;
        } while (pathQ!=1&&pathP!=1);
        return root;
    }
    static long num=1;
    public static boolean getPathOfNode(TreeNode root,TreeNode node){//判断node节点在不在root树中
        if (root==null) return false;
        boolean a = getPathOfNode(root.left, node);
        boolean b = getPathOfNode(root.right, node);
        if (root==node) return true;
        if (a){
            num=num*10;
        }else if (b){
            num=num*10+1;
        }
        return a||b;
    }







    private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
