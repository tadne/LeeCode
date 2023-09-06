package NewLeeCode;

import java.util.Arrays;
import java.util.HashSet;

public class code41 {
    public static void main(String[] args) {
        //给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
        //
        //请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
        //
        int[] nums={1,2};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
            Arrays.sort(nums);
            int j=1;
            for (int i = 0; i <nums.length; i++) {
                if (nums[i]>0) {
                    if (i==0&& nums[i]!=j) return j;
                    if (i>0&&nums[i] != j&& nums[i]!=nums[i-1]) return j;
                    if ((i>0&&nums[i]!=nums[i-1]||i==0)) j++;
                    if (i==nums.length-1&&nums[i] == j) return j+1;
                }
            }
            return j;
    }






    public static int firstMissingPositive1(int[] nums) {
        Arrays.stream(nums).filter(s->s>0);
        HashSet hashSet=new HashSet();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= nums.length+1; i++) {
            boolean add = hashSet.add(i);
            if (add){
                return i;
            }
        }
        return 0;

    }


}
