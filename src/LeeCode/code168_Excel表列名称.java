package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code168_Excel表列名称{
    public static void main(String[] args) {
        //给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
        //例如：
        //A -> 1
        //B -> 2
        //C -> 3
        //...
        //Z -> 26
        //AA -> 27
        //AB -> 28
        //...
        System.out.println(convertToTitle(701));
    }
    public static String convertToTitle(int columnNumber) {
        StringBuilder res=new StringBuilder();
        if (columnNumber==0) return "A";
        while (columnNumber>0){
            int count=(columnNumber-1)%26;//目标映射是1->A,26->Z
            res.append((char) ('A'+count));
            columnNumber=(columnNumber-1)/26;//循环
        }
        return res.reverse().toString();
    }
}
