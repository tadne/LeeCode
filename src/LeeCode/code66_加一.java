package LeeCode;

import java.util.Arrays;

public class code66_加一 {
    public static void main(String[] args) {
        //给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
        //
        //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
        //
        //你可以假设除了整数 0 之外，这个整数不会以零开头。
        int[]arr={9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
    public static int[] plusOne(int[] digits) {
        int m=digits.length,n=m;
        if (m==1) {//长度为1
            if (digits[0]==9) {
                return new int[]{1, 0};
            }else digits[n-1]++;
            return digits;
        }
        digits[n-1]++;//加一
        while (n-->1){//逆序循环,但是停在最后一个上
            if (digits[n]==10) {
                digits[n]=0;
                digits[n-1]++;
            }else return digits;
        }
        if (digits[n]==10) digits[n]=0;//判断最后一个
        else return digits;
        int[]res=new int[m+1];//处理重建数组的情况,即数组第一位是9的情况
        res[0]=1;
        System.arraycopy(digits, 0, res, 1, m);
        return res;
    }
}
