package LeeCode;

public class code263_丑数 {
    public static void main(String[] args) {
        //丑数 就是只包含质因数 2、3 和 5 的正整数。
        //
        //给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
    }
    //不断取出因子2,3,5.如果最后为1,说明可以整除,说明是丑数
    public boolean isUgly(int n) {
        if (n<0) return false;
        while (n%2==0) n/=2;
        while (n%3==0) n/=3;
        while (n%5==0) n/=5;
        return n==1;
    }
}
