package Leecode2;

import java.util.HashSet;
import java.util.Set;

public class code36_有效数独 {
    public static void main(String[] args) {
        //请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
        //
        //数字 1-9 在每一行只能出现一次。
        //数字 1-9 在每一列只能出现一次。
        //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row=new HashSet<>();
            Set<Character> col=new HashSet<>();
            for (int j = 0; j < 9; j++) {
                //行
                if (board[i][j]!='.'){
                    if (!row.add(board[i][j]))return false;
                }
                //列
                if (board[j][i]!='.'){
                    if (!col.add(board[j][i]))return false;
                }
                //块
                if (i<3&&j<3){
                    Set<Character> block=new HashSet<>();
                    for (int k = 3*i; k < 3+3*i; k++) {
                        for (int l = 3*j; l < 3+3*j; l++) {
                            if (board[k][l]!='.'&&!block.add(board[k][l])) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
