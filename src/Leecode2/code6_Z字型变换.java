package Leecode2;

import java.util.Arrays;

public class code6_Z字型变换 {
    public static void main(String[] args) {
        //将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
        //
        //比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
        //
        //P   A   H   N
        //A P L S I I G
        //Y   I   R
        //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
        String s="123456789";
        System.out.println(convert(s, 4));
    }
    //数学方法
    //规则
    //  起始下标都是行号
    //  第0层和第numRows-1层的下标间距总是step 。
    //  中间层的下标间距总是 step-2*行数、2*行数交替。
    //  下标不能超过len(s)-1
    public static String convert1(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        int step = 2 * numRows - 2;
        int n = s.length(), index = 0;
        char[] ans = new char[n];
        for (int i = 0; i < numRows; i++) {//i表示：当前行
            for (int j = 0; j + i < n; j += step) {
                ans[index++] = s.charAt(j + i);//每行第一个
                if (i > 0 && i < numRows-1 && j + step - i < n) {//按step-2*i和2*i交替计算当前行该元素的位置
                    ans[index++] = s.charAt(j + step - i);
                }
            }
        }
        return new String(ans);
        //作者：Mia
        //链接：https://leetcode.cn/problems/zigzag-conversion/solutions/9490/6-z-zi-xing-bian-huan-c-c-by-bian-bian-xiong/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }




    //字符串按层拼接
    public static String convert(String s, int numRows) {
        int len = s.length();
        String[] strs=new String[numRows];
        Arrays.fill(strs, "");
        for (int i = 0; i < len; ) {
            for (int j = 0; j < numRows&&i<len; j++,i++) {
                strs[j]+=s.charAt(i);
            }
            for (int j = numRows-2; j >= 1&&i<len; j--,i++) {
                strs[j]+=s.charAt(i);
            }
        }
        StringBuilder res= new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
