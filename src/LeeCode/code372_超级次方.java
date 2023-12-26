package LeeCode;

import static LeeCode.code130_被围绕的区域.n;

public class code372_超级次方 {
    public static void main(String[] args) {
        //你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
        System.out.println(superPow(2, new int[]{1,0}));
    }
    //x=(1337+z)
    //那么 x^y %1337 = z^y %1337
    public static int superPow(int a, int[] b) {
        if (a==1) return 1;
        a=a%1337;
        int res=1;
        for (int i = b.length - 1; i >= 0; i--) {
            res=(int) (((long)res*pow(a,b[i]))%1337);
            a=pow(a,10);
        }
        return res;
    }
    //pow=pow/2+pow%2
    public static int pow(int num,int pow){
        int res = 1;
        while (pow!=0){
            if (pow%2!=0) res=(int)((long)res*num%1337);
            num = (int) (((long) num * num) % 1337);
            pow /= 2;
        }
        return res;
    }
}
