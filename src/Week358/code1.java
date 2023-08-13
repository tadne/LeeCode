package Week358;

public class code1 {
    public static void main(String[] args) {
        //给你一个下标从 0 开始的整数数组 nums 。请你从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等。
        //
        //返回最大和，如果不存在满足题意的数字对，返回 -1 。
        //nums = [51,71,17,24,42]
        //nums = [1,2,3,4]
        //2 <= nums.length <= 100
        //1 <= nums[i] <= 104
        int[] nums={1,2,3,4};
        System.out.println(maxSum(nums));

    }
    public static int maxSum(int[] nums) {
        int l=0;
        int r=1;
        int max=-1;
        int[] vis=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            vis[i]=getMaxNum(nums[i]);
        }
        while (l!=nums.length-1){
            if (vis[l]==vis[r]) {
                max=Math.max(max,nums[l]+nums[r]);
                r++;
            }else r++;
            if (r==nums.length) {
                l++;
                r=l+1;
            }
        }
        return max;
    }
    public static int getMaxNum (int a){
        int max=0;
        while (a!=0) {
            max=Math.max(max,a%10);
            a/=10;
        }
        return max;
    }
}
