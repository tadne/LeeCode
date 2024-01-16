package LeeCode;

public class code8_字符串转换整数 {
    public static void main(String[] args) {
        //请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
        //
        //函数 myAtoi(string s) 的算法如下：
        //
        //丢弃无用的前导空格
        //确定最终结果是负数还是正数
        //读入字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        //将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
        //如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。
        // 具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
        //返回整数作为最终结果。
        //s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
        System.out.println(myAtoi1( "   -42"));
    }
    public static int myAtoi1(String s) {
        long res = 0;
        int sign=1,idx=0;
        int len=s.length();
        while (idx<len&&s.charAt(idx)==' '){//跳过空格
            idx++;
        }
        if (idx<len&&s.charAt(idx)=='-'){//确定符号
            sign=-1;
            idx++;
        }else if(idx<len&&s.charAt(idx)=='+') idx++;
        while (idx<len&&s.charAt(idx)<='9'&&s.charAt(idx)>='0'){//数字
            res=res*10+s.charAt(idx++) - '0';
            // 判断是否溢出, 为了避免 res 超过long型最大值,所以将溢出判断放在循环中
            if (sign==1&&res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }else if (sign==-1 && res>(long) Integer.MAX_VALUE+1){
                return Integer.MIN_VALUE;
            }
        }
        return (int) (res*sign);
    }

}
