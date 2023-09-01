package NewLeeCode;

import java.util.HashMap;
import java.util.Map;

public class code560 {
    public static void main(String[] args) {
        //给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
        int[] arr={1,1,1};
        int k=1;
        System.out.println(subarraySum(arr, k));
    }
    //前缀和优化:    就是用map集合来处理前缀和数组中元素,来避免其中的重复项的遍历
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//设置初始值
        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            // 获取前缀和为 preSum - k 的个数
            if (map.containsKey(preSum - k))
                count += map.get(preSum - k);
            //维护map集合
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    //用前缀和来优化计算区间和
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];//前缀和
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (preSum[j + 1] - preSum[i] == k) count++;
            }
        }
        return count;
    }
   



    //用递归暴力破解
    static int count=0;
    public static int subarraySum(int[] nums, int k) {
       subarraySum(nums,k,0);
       return count;
    }
    public static void subarraySum(int[] nums,int k,int idx){
        if (idx==nums.length) return;
        int sum=0;
        for (int i = idx; i < nums.length; i++) {
            sum+=nums[i];
            if (sum==k) count++;
        }
        subarraySum(nums,k,idx+1);
    }


}
