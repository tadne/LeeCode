package LeeCode;

import java.util.Arrays;

public class code65 {
    public static void main(String[] args) {
        //给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
        //
        //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
        //
        //你可以假设除了整数 0 之外，这个整数不会以零开头。
        int [] ints={9,8,9};
        System.out.println(Arrays.toString(plusOne(ints)));
    }
    public static int[] plusOne(int[] digits) {
        int len =digits.length;
        digits[len-1]++;
        if (digits[len-1]!=10) {//最后一位不是10就可以直接返回
         return digits;
        }
        for (int i = len-1; i >=0; i--) {
            if (digits[i]!=10) {//如果当前位置不是10就返回
                return digits;
            } else if (digits[i]==10&&i!=0){//是10就变0,前一位+1,避免边界
                digits[i]=0;
                digits[i-1]++;
            } else if (i==0&&digits[i]==10) {//处理边界
                int []dest=new int[len+1];//只有数字是999...9才会出现这种情况
                dest[0]=1;
                return dest;
            }
        }
        return digits;
    }
}
