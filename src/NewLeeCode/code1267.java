package NewLeeCode;

import java.util.HashMap;
import java.util.Map;

public class code1267 {
    public static void main(String[] args) {
        //这里有一幅服务器分布图，服务器的位置标识在  m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
        //
        //如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
        //
        //请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。

       int[][] grid = { {1,1,1,0},  //  2 2 3 1 :4+
                        {0,1,1,0},  //3
                        {1,0,1,0},  //2
                        {0,0,0,1}}; //2
                                    //1
        System.out.println(countServers(grid));
    }
    //这个题我认为是一定是存在  一次遍历就得到结果 的方法
    //但是我还没想出来
    public static int countServers(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int result = 0;
        int[] rowCount = new int[row];//当前行1的数量
        int[] colCount = new int[col];//当前列1的数量
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                    result++;
                }
            }
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == 1 && (rowCount[i] == 1 && colCount[j] == 1)){
                    result--;
                }
            }
        }
        return result;
    }

}
