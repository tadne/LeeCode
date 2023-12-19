package LeeCode;

public class code342_4的幂 {
    public static void main(String[] args) {
        //给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
        //
        //整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
        System.out.println(isPowerOfFour(1));
    }
    //4的幂:  1,4,16..
    //1,100,10000
    //可以发现,4的幂的二进制位只有一个1,而且这个1在奇数位上
    // 只有一个1,那么它满足是2的幂,即满足 n&(n-1)=0
    // 在偶数位上,那么它肯定与这个数 10101010101010101010101010101010 (也就是偶数位都是1,奇数位都是0)的 & 运算是0
    public static boolean isPowerOfFour(int n) {
        return n>0&&(n&(n-1))==0&&(n&0b10101010101010101010101010101010)==0;
    }

}
