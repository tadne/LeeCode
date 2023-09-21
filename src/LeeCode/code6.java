package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code6 {
    public static void main(String[] args) {
        //将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
        //
        //比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
        //P   A   H   N         P           I           N
        //A P L S I I G         A       L   S       I   G
        //Y   I   R             Y   A       H   R
        //                      P           I
        //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
        //PAYPALISHIRING==>PAHN==>AYPLISIRIG==>ALIG
        //
        //1 <= s.length <= 1000
        //s 由英文字母（小写和大写）、',' 和 '.' 组成
        //1 <= numRows <= 1000
        System.out.println(convert("PAYPALISHIRING", 3));
    }
    //首先从数学的角度讲,我认为应该是存在一个算法,或者说公式,可以找对对应行的规律计算出对应元素应该在的位置的,
    // 比如第一行就是每隔开(numRows-2)*2+1个元素就是它的第一行的元素
    //  不过这里就不浪费这个时间找规律了

    //朴素的分开装元素,然后合并
    public static String convert(String s, int numRows) {
        if (numRows==1) return s;
        List<StringBuilder> lists=new ArrayList<>();//分开装元素
        for (int i = 0; i < numRows; i++) {//初始化
            lists.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < lists.size()&&i<s.length();i++,j++) {//从上到下
                lists.get(j).append(s.charAt(i));
            }
            for (int j = lists.size()-2; j > 0&&i<s.length(); j--,i++) {//从下到上
                lists.get(j).append(s.charAt(i));
            }
        }
        StringBuilder res=new StringBuilder();
        lists.forEach(res::append);//遍历合并
        return res.toString();
    }
    
}
