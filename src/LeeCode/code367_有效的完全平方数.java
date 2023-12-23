package LeeCode;

public class code367_有效的完全平方数 {
    public static void main(String[] args) {
        //给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
        //
        //完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
        //
        //不能使用任何内置的库函数，如  sqrt 。
    }
    //神奇的二分查找
    public boolean isPerfectSquare(int num) {
        int l=0,r=num;
        while (r>=l){
            int mid=l+(r-l)/2;
            long squ= (long) mid * mid;
            if (num>squ) l=mid+1;
            else r=mid-1;
        }
        return num==l*l;
    }
}
