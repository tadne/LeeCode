package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code393_utf8编码验证 {
    public static void main(String[] args) {
        //给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
        //
        //UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
        //
        //对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
        //对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
        int[]data={250,145,145,145,145};
        System.out.println(validUtf8(data));
    }
    public static boolean validUtf8(int[] data) {
        int n=data.length;
        for (int i = 0; i < data.length; i++) {
            int count=0;//当前字符的字节数

            int num=data[i];
            System.out.println(Integer.toBinaryString(num));
            int tmp=7;
            while (((num>>tmp)&1) == 1) {//得到当前字符的字节数
                count++;
                tmp--;
            }

            //如果是一个字节的字符
            if (count==0||count==1){
                if (count==1) return false;//一个字节的字符的第一位是0
                continue;
            }

            //n个字节的字符(n>1)
            if (((num>>tmp)&1) == 1||count>4) return false;//第n+1为设为0 或 一个字节的字符数超过4
            //判断该字符后面字节的前两位为10
            for (int j = 1; j < count; j++) {
                if (++i==n) return false;//当前字符的字节数不足
                int num1=data[i];
                if ((((num1>>7)&1) == 0) || (((num1>>6)&1) == 1)) return false;//后面字节的前两位是10
            }
        }
        return true;
    }
}
