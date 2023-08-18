package NewLeeCode;

public class code1749 {
    public static void main(String[] args) {
        //给你一个整数数组 nums 。
        // 一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
        //请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
        //
        //1 <= nums.length <= 105
        //-104 <= nums[i] <= 104
        int[]nums = {-2,-9,12,-13};
        System.out.println(maxAbsoluteSum2(nums));
    }
    //前缀和,就是前n项-前m项=第m~n项
    public static int maxAbsoluteSum2(int[] nums) {
        int s = 0, mx = 0, mn = 0;//初始值为0,mx是前m项和最大值,mn是前n项和最小值,m和n是不固定的,并且mx最小值为0,mn最大值为0
        for (int x : nums) {
            s += x;//s是前n项和
            if (s > mx) mx = s;//如果前n项和大于上一个最大值,就将其赋值给mx(初始值为0,前)
            else if (s < mn) mn = s; //否则如果前n项和小于上一个最小值,就将其赋值给mn
        }
        //最终的mx就是最大的前n项和
        //最终的mn就是最小的前m项和
        return mx - mn;//相减得到最大n-m项和,而且不用考虑正负
        //为什么不用考虑正负?
        //因为mn是负数,它的最大值是0.mx是正数,最小值是0.
    }

    public static int maxAbsoluteSum1(int[] nums) {
        int positiveSum=0,positiveMax=0;
        int negativeSum=0,negativeMin=0;
        for (int num : nums) {
            positiveSum+=num;
            positiveMax=Math.max(positiveSum,positiveMax);
            positiveSum=Math.max(0,positiveSum);
            negativeSum+=num;
            negativeMin=Math.min(negativeSum,negativeMin);
            negativeSum=Math.min(0,negativeSum);
        }
        return Math.max(positiveMax,-negativeMin);
    }

    //我的丑陋算法
    public static int maxAbsoluteSum(int[] nums) {
        int max=0;
        int sum = 0;
        int r;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) continue;
            sum=0;
            sum+=nums[i];
            nums[i]=0;
            r=i;
            if (sum>0){
                while (r<nums.length&&sum>0){
                    sum+=nums[r];
                    max=Math.max(max,sum);
                    r++;
                }
            }else if (sum<0){
                while (r<nums.length&&sum<0){
                    sum+=nums[r];
                    max=Math.max(max,-1*sum);
                    r++;
                }
            }
        }
        return max;
    }
}
