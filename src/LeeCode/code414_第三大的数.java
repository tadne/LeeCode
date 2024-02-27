package LeeCode;

import java.util.HashSet;
import java.util.Set;

public class code414_第三大的数 {
    public static void main(String[] args) {
        //给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
        //要求返回第三大的数，是指在所有不同数字中排第三大的数。
        int[] arr=new int[]{1,2,-2147483648};
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] nums) {
        long max1=Long.MIN_VALUE,max2=Long.MIN_VALUE,max3=Long.MIN_VALUE;//long型避免数字不够小导致结果错误
        for (int num : nums) {
            if (num > max1) {//比最大还大，那就要放在最大位置，后面的后移
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {//小于或等于最大，要排除等于第一的情况
                if (num==max1) continue;
                max3 = max2;
                max2 = num;
            } else if (num > max3) {//小于等于第二，排除等于第二的情况
                if (num==max2) continue;
                max3 = num;
            }
        }
        if (max3==Long.MIN_VALUE) return (int) max1;
        else return (int) max3;
    }
}
