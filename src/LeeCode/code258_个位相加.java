package LeeCode;

public class code258_个位相加 {
    public static void main(String[] args) {
        //给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
    }
    //常规解法
    public int addDigits(int num) {
        while (num>=10){
            int tmp=0;
            while (num!=0){
              tmp+=num%10;
              num/=10;
            }
            if (tmp<10) return tmp;
            else num=tmp;
        }
        return num;
    }
    //数学方法,记ai位num的第i位数
    //num = ai*(10^i)的i位求和 = (10^i-1)*ai求和 + ai的求和
    //而 (10^i-1) 的求和是9的倍数, 也就是说 num 和 ai的求和 对于9 的余数相同
    //也就是说 num%9 = ai的求和%9
    public int addDigits1(int num) {
        if (num==0) return num;
        else if (num%9==0) return 9;
        else return num%9;
    }
}
