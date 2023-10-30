package LeeCode;

import java.io.IOException;
import java.io.Serializable;

public class code53_最大子数组和 {
    public static void main(String[] args) throws IOException {
        //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
        //
        //子数组 是数组中的一个连续部分。
        int[] nums = {1, -100,1};
        System.out.println(maxSubArray1(nums));
    }
    public static  int maxSubArray3(int [] arr){
        int max=arr[0];
        int sum=0;
        for (int j : arr) {
            if (sum < 0) {//如果sum<0，说明sum不可能变的更大了，因为它加下一个没有下一个大
                sum = j;
            } else sum += j;//否则sum就可能可以继续增长
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum<0){//如果sum<0，说明sum不可能变的更大了，因为它加下一个没有下一个大
                sum=nums[i];
            }else {//如果大于0,说明当前和可能可以继续增长
                sum += nums[i];
            }
            max = Math.max(max, sum);//及时将最大值传给max
        }
        return max;
    }

    public static int maxSubArray1(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static int maxSubArray(int[] nums) {
        int sum =0;
        int max=Integer.MIN_VALUE;
        int j=0;
        if (nums.length==1) return nums[0];
        for (int i = 0; j+i < nums.length; ) {
            sum+=nums[j+i];
            i++;
            max = Math.max(sum, max);
            if (sum<=0){
                sum=0;
                i=0;
                j++;
                continue;
            }
        }
        return max;
    }


}
