package LeeCode;

public class code441_排列硬币 {
    public static void main(String[] args) {
        //你总共有 n 枚硬币，并计划将它们按阶梯状排列。
        // 对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
        //
        //给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
        //
        //
        System.out.println(arrangeCoins1(8));
    }
    //等差数列，用sum求n， 也就是（-1+（8n）^(1/2)）/2，一元二次方程
    public static int arrangeCoins1(int n) {
        long num=n;
        return (int) Math.abs((-1+Math.sqrt(1+8*num))/2);
    }

    //朴素循环
    public static int arrangeCoins(int n) {
        int num=n;
        for (int i = 0; i < n; i++) {
            num-=i;
            if (num==i+1) return i+1;
            else if (num<=i+1) return i;
        }
        return 0;
    }
}
