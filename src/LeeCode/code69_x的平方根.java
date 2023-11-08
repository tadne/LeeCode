package LeeCode;

public class code69_x的平方根 {
    public static void main(String[] args) {
        //给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
        //
        //由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
        //
        //注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

        System.out.println(mySqrt2(2147395600));


    }
    //二分查找法,1ms,速度还是比较快的
    public static int mySqrt2(int x) {
        if (x==0) return 0;
        long left=1,right=10;
        while (true){
            if (left*left<=x&&right*right>x){
                while (true){
                    long mid = left+(right-left)/2;
                    boolean flag1 = mid*mid<=x,flag2 = (mid+1)*(mid+1)>x;
                    if (flag1&&flag2) {
                        return (int) mid;
                    }else if (flag1){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }else {
                left *= 10;
                right *=10;
            }
        }
    }

    public static int mySqrt(int x) {
        long res=0;
        while (true){
            if (res*res<=x&&(res+1)*(res+1)>x) return (int) res;
            res++;
        }
    }
    //泰勒级数
    public static int mySqrt1(int x) {
        if (x == 0) return 0;
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);//一阶表达式
            if (Math.abs(x0 - xi) < 1e-7) break;
            x0 = xi;
        }
        return (int) x0;
    }
}
