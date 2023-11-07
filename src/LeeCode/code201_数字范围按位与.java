package LeeCode;

public class code201_数字范围按位与 {
    public static void main(String[] args) {
        //给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
        //
        //   110  111 == 110
        System.out.println(rangeBitwiseAnd(6, 7));
    }
    //因为left到right递增，每次二进制最右边加一
    //这样就导致其实left到right之间只有最右边有变化
    //在与运算中,遇到0就会变成0,所以 所有数字的按位与运算 会让答案的右边都是0
    //也就是现在只有找到left和right相等的部分,其余置0就是答案
    public static int rangeBitwiseAnd(int left, int right) {
        int i=0;
        while (left<right){
            left>>=1;
            right>>=1;
            i++;
        }
        return right<<i;
    }
}
