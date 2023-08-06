package Week356;

import java.util.Arrays;

public class code2 {
    public static void main(String[] args) {
        //给你一个由 正 整数组成的数组 nums 。
        //
        //如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
        //
        //子数组中 不同 元素的数目等于整个数组不同元素的数目。
        //返回数组中 完全子数组 的数目。
        //
        //子数组 是数组中的一个连续非空序列。

        System.out.println(countCompleteSubarrays(new int[]{1917,1917,608,608,1313,751,558,1561,608}));
        //1917,1917,608,608,1313,751,558,1561,608
        //1917,1917,608,608,1313,751,558,1561
        //1917,1917,608,1313,751,558,1561

        //1917,608,1313,751,558,1561
        //1917,608,608,1313,751,558,1561
        //1917,608,608,1313,751,558,1561,608
    }
    public static int countCompleteSubarrays(int[] nums) {
        Arrays.sort(nums);
        int[] ints=new int[nums.length];
        Arrays.fill(ints,1);
        int idx=0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i]!=nums[i-1]) {
                idx++;
            }else  ints[idx]++;
        }
        int res=1;
        if (ints[0]==nums.length) {
            res=0;
            for (int i = 0; i < nums.length; i++) {
                res+=ints[0];
                ints[0]--;
            }
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (ints[i]!=0) res*=ints[i];
        }
        return res;
    }
}
