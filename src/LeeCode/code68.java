package LeeCode;

public class code68 {
    public static void main(String[] args) {
        //给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
        //
        //由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
        //
        //注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

        System.out.println(mySqrt(2147395600));


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
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);//一阶表达式
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;

    }
}
