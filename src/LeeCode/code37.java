package LeeCode;

import java.util.HashSet;

public class code37 {

    public static void main(String[] args) {
//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//
//数字 1-9 在每一行只能出现一次。
//数字 1-9 在每一列只能出现一次。
//数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
        char[][] board={
                  {'.', '.', '4', '.', '.', '.', '6', '3', '.'}
                , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'5', '.', '.', '.', '.', '.', '.', '9', '.'}
                , {'.', '.', '.', '5', '6', '.', '.', '.', '.'}
                , {'4', '.', '3', '.', '.', '.', '.', '.', '1'}
                , {'.', '.', '.', '7', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '5', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> checkRow=new HashSet<>();
            HashSet<Character> checkColumn=new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int k=0;
                if (board[i][j]!='.' ) {
                    //列判断
                    if (!checkColumn.add(board[j][i])) return false;
                }
                if (board[j][i]!='.' ) {
                    //行判断
                   if (!checkRow.add(board[i][j])) return false;
                }
                if (i<3&&j<3) {
                    //方块判断
                    HashSet<Character> checkBlock=new HashSet<>();
                    for (int l = i * 3; l < 3+i*3; l++) {
                        for (int m = j * 3; m < 3+j*3; m++) {
                            if (board[l][m]!='.'&&!checkBlock.add(board[l][m])) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
 

}
