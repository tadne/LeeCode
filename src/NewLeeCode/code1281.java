package NewLeeCode;

public class code1281 {
    public static void main(String[] args) {
        //给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
        int n=1234;
        System.out.println(subtractProductAndSum(n));
    }
    public static int subtractProductAndSum(int n) {
        int mul=1;
        int sum=0;
        while (n>0){
            int temp=n%10;//获取位上数字
            mul*=temp;
            sum+=temp;
            n/=10;//删除当前位数字
        }
        return mul-sum;
    }
}
