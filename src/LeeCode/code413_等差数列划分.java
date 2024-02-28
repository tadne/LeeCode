package LeeCode;

public class code413_等差数列划分 {
    public static void main(String[] args) {
        //如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
        //
        //例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
        //给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
        //
        //子数组 是数组中的一个连续序列。
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
    //获取等差数列的个数，那么其实要找到所有不连续的等差数列的长度
    //接下来要计算一个长度为n的等差数列有多少长度大于等于3的子数组： 1+2+3+...+n-2
    //这其实是一个等差数列求和，
    public static int numberOfArithmeticSlices(int[] nums) {
        int sum=0;
        int len=2;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]-nums[i-1]==nums[i+1]-nums[i]){
                len++;
            }else if (len>2){
                sum+= (len-1)*(len-2)/2;
                len=2;
            }
        }
        if (len>2){
            sum+= 2*len-5;
            len=2;
        }
        return sum;
    }
}
