package LeeCode;

public class code427_构建四叉树 {
    public static void main(String[] args) {
        //给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
        //
        //你需要返回能表示矩阵 grid 的 四叉树 的根结点。
        //
        //四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
        //
        //val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
        //isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
        //class Node {
        //    public boolean val;
        //    public boolean isLeaf;
        //    public Node topLeft;
        //    public Node topRight;
        //    public Node bottomLeft;
        //    public Node bottomRight;
        //}
        //我们可以按以下步骤为二维区域构建四叉树：
        //
        //如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
        //如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
        //使用适当的子网格递归每个子节点。

        //总结
        //先检查矩阵内所有位置是不是全部值都一样
        //如果值一样，树结点的 val 设为对应的布尔值，isLeaf 设为 true 表示没有孩子结点并将四个孩子结点指针设为 null, 结束并返回
        //如果矩阵内值不全一样，那 isLeaf 设置为 false 表示有孩子结点,然后画个十字将矩阵等分成四个正方形小矩阵，
        // 对每个小矩阵递归执行上述步骤并将当前树结点的四个孩子指针指向"递归操作返回的四个树结点".
    }
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid.length);
    }
    //用r0,r1,c0,c1来圈定小矩阵
    public Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean same = true;
      loop:  for (int i = r0; i < r1; ++i) {
            for (int j = c0; j < c1; ++j) {
                if (grid[i][j] != grid[r0][c0]) {//如果矩阵内不全一样,说明有子节点,将same设为false并结束循环
                    same = false;
                    break loop;
                }
            }
        }
        if (same) return new Node(grid[r0][c0] == 1, true);//如果都是一样的,那就直接将四个子节点设为nil,直接返回
        Node ret = new Node(//如果不一样
                true,//val值就不重要,可以随意设置
                false,//isLeaf要设置为false,表示有子节点
                //四个子节点就可以分别递归,只要将拆分的四个小矩阵放入即可
                dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                dfs(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                dfs(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)
        );
        return ret;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/construct-quad-tree/solutions/1449809/jian-li-si-cha-shu-by-leetcode-solution-gcru/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

}
