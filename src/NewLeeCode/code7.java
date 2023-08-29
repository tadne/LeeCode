package NewLeeCode;

public class code7 {
    public static void main(String[] args) {
        //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
        //
        //如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
        //
        //假设环境不允许存储 64 位整数（有符号或无符号）。
    }
    //还可以用数组什么的,存进去反转
    //
    // 就是还提前检查 int最大值/10 那样子

    //强转
    public int reverse(int x) {
        long res=0;
        int sign= (x>0)?1:-1;
        x=x*sign;
        while (x!=0){
            res=res*10+x%10;
            x/=10;
        }
        res=res*sign;
        return res>Integer.MAX_VALUE||res<Integer.MIN_VALUE?0: (int) res;
    }



}
