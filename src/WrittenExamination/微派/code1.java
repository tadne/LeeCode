package WrittenExamination.微派;

import java.util.Arrays;

public class code1 {
    public static void main(String[] args) {
        //给一个数组，一个目标值，要求找到一对和等于目标值的数
        //结果中肯定有这么一对值
        int[]arr={1,2,3,4,5,7};
        int tar=5;
        System.out.println(Arrays.toString(getSumOfTar(arr, tar)));
    }
    public static int[] getSumOfTar(int[]nums,int tar){
        Arrays.sort(nums);
        int[] ans=new int[2];
        for (int i = 0; i < nums.length; i++) {
            ans[1]=Arrays.binarySearch(nums,tar-nums[i]);
            if (ans[1]!=-1){
                ans[0]=i;
                return ans;
            }
        }
        return ans;
    }

}
