package LeeCode;

public class code152_乘积最大子数组 {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
        //
        //测试用例的答案是一个 32-位 整数。
        //
        //子数组 是数组的连续子序列。
        int[]arr={0,-1,2,1};
        System.out.println(maxProduct(arr));
    }

    //如果没有负数,我们的公式就是 max=Math.max(max*nums[i],nums[i])
    //有了负数出现了什么情况? : 就是会让最大值变成最小值,最小值变成最大值
    //如果我们维护一个当前最小值,出现负数时,就让最大值和最小值进行交换,就能解决问题
    //imax: 当前最大值
    //imin: 当前最小值
    //max:  实际最大值
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {//出现负数,进行交换
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);
            max = Math.max(max, imax);
        }
        return max;

//        作者：画手大鹏
//        链接：https://leetcode.cn/problems/maximum-product-subarray/solutions/7561/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

}
