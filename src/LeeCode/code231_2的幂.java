package LeeCode;

public class code231_2的幂 {
    public static void main(String[] args) {
        //给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
        //
        //如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
    }
    // 假设 n的二进制位为:      abcd10..0
    // 那么 n-1的二进制位:     abcd01..1
    // 那么 n & (n-1)就会变成将最后的1给抹除,并且在abcd中只保留为1的二进制位
    // 我们的目标是希望 abcd都是0,这样就是2的幂次
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
