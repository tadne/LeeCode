package LeeCode;

public class code326_3的幂 {
    public static void main(String[] args) {
        //给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
        //
        //整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
    }
    public boolean isPowerOfThree(int n) {
        if (n<=0) return false;
        while (n % 3 == 0){
            n/=3;
        }
        return n==1;
    }
    //取int下最大的3的幂找对应因子
    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
