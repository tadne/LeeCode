package OldLeeCode;

public class code50 {
    public static void main(String[] args) {
        //实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
        //-100.0 < x < 100.0
        //-2^31 <= n <= 2^31-1
        //n是一个整数
        //要么 x 不为零，要么 n > 0 。
        //-104 <= xn <= 104
    }
    public double myPow(double x, int n) {
        //思路: 2^101=2*4^50=2*16^25=2*16*16^24=2*16*169^12=....
        if(x == 0) return 0;
        double res = 1;
        long m=n;
        if(m < 0) {//负次幂
            x = 1 / x;
            m = -m;
        }
        while(m > 0) {
            if((m%2) == 1) {//如果m是奇数,就称一个变成偶数
                res *= x;
                m--;
            }else {//如果是偶数,就可以让x=x*x;
                x *= x;
                m=m>>1;
            }
        }
        return res;
    }





}
