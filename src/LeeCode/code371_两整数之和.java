package LeeCode;

public class code371_两整数之和 {
    public static void main(String[] args) {
        //给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
    }
    // 位运算
    // 0+0=0 0+1=1 1+0=1  1+1=0(进位)
    // 当两个都是1的时候需要进位,这就是 & 运算 :  (a & b) << 1
    // 当相同的时候是0,不同的时候是1,这是异或运算: a ^ b
    // 以上获得的两个值还需要重复计算,因为有可能出现多次进位的情况
    //
    public int getSum(int a, int b) {
        while (b!=0){
            int carry = ( a & b ) << 1;//获得需要进位的值并进位
            a = a ^ b;//考虑进位加和
            b = carry;
        }
        return a;
    }

}
