package NewLeeCode;

public class code79 {
    public static void main(String[] args) {
        //给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
        //
        //单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
        //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        //"SEE"
        char[][] board={{'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};
        String word="ABCES";
        System.out.println(exist1(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){//遍历
                if(dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    //判断当前位置
    public static boolean dfs(char[][] board,String word,int index,int x,int y){//数组,单词,单词索引,位置i,位置j
        if(x<0||x>board.length-1||y<0||y>board[0].length-1||board[x][y]=='.'||board[x][y]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){//找到了
            return true;
        }else{
            char temp=board[x][y];//临时修改
            board[x][y]='.';//为当前位置去重
            boolean b=dfs(board,word,index+1,x+1,y)||dfs(board,word,index+1,x-1,y)||
                    dfs(board,word,index+1,x,y+1)||dfs(board,word,index+1,x,y-1);//递归上下左右
            board[x][y]=temp;//临时修改改回
            return b;
        }

    }
    public static boolean exist1(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {//第一个
            return false;
        } else if (k == s.length() - 1) {//长度为1
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//方向
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];//加方向
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {//范围
                if (!visited[newi][newj]) {//避免下一次判断回头和判断已经判断过的位置
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

}
