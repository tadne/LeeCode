package LeeCode;

public class code190_颠倒二进制位 {
    public static void main(String[] args) {
        //颠倒给定的 32 位无符号整数的二进制位。
        //
        //提示：
        //
        //请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
        //在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。

        //n = 00000010100101000001111010011100
        //输出：964176192 (00111001011110000010100101000000)
        int n= 43261596;
        System.out.println(reverseBits1(n));
    }

    //就是将不断用  | 运算获取n的最右位,再利用 >> 来去除已经获取的位
    //将获取的位 再通过 << 的方式加到 res 上
    public static int reverseBits1(int n) {
        int rev = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < 32 && n != 0; ++i) {
            int val = n & 1;//得到当前n的最右一位
            int mob = 31 - i;//要移动的位数
            rev |= val << mob; //左移,并且进行一次或运算 |= 整合每一位的结果
            n >>>= 1; //零填充右移1位去除已经获取的位
        }
        return rev;
    }

}
