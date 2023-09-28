package LeeCode;

public class code289_生命游戏 {
    public static void main(String[] args) {
        //给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
        // 每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
        // 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
        //
        //如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
        //如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
        //如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
        //如果死细胞周围正好有三个活细胞，则该位置死细胞复活；

        //下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
    }
    //老套的办法,就是搞一个新数组记录老数组,对照更新
    public void gameOfLife(int[][] board) {
        int m = board.length,n = board[0].length;
        int[][] newBoard=new int[m][n];
        for (int i = 0; i < m; i++) {//复制
            System.arraycopy(board[i], 0, newBoard[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]=rule(newBoard,i,j,m,n);
            }
        }
    }

    /**
     * 判断状态更新当前细胞
     * @param board 用于对照的数组
     * @param i 要修改的细胞行
     * @param j 要修改细胞列
     * @param m 边界行
     * @param n 边界列
     * @return 修改后的细胞状态
     */
    public int rule(int[][] board,int i,int j,int m,int n){
        int count=0;
        int state=board[i][j];
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int row=i-1+k,col=j-1+l;
                if (row>=0&&row<m&&col>=0&&col<n&&board[row][col]==1) count++;
            }
        }
        if (state==1) {
            count--;
            if (count<2||count>3) return 0;
            else return 1;
        }else return count==3?1:0;
    }

}
