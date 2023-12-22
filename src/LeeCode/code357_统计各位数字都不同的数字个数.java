package LeeCode;

public class code357_统计各位数字都不同的数字个数 {
    public static void main(String[] args) {
        //给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n 。
        //0<=n<=8
    }
    //个位数自然直接返回
    //十位数,[1~9,0~9],第一位和第二位都有9种可能性,第一位可能性为1~9,第二位的可能性为0~9再除去上一位的选择,也就是9*9=81种可能性
    //百位数,[1~9,0~9,0~9],两个相同的概率为 9*9*8
    //千位数,9*9*8*7
    //...
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int res = 10, num = 9;
        for (int i = 0; i < n - 1; i++) {
            num *= 9 - i;
            res += num;
        }
        return res;
    }
}
