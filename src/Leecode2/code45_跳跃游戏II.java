package Leecode2;

public class code45_跳跃游戏II {
    public static void main(String[] args) {
        //给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
        //
        //每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
        //
        //0 <= j <= nums[i]
        //i + j < n
        //返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
        //题目保证可以到达 nums[n-1]
        //1 <= nums.length <= 104

        int[]arr={2,3,1,1,4};
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        int len=nums.length;
        int step=1;
        //到目前为止，能跳到的最远距离
        int max=nums[0];
        //第step步能到达的最远距离
        int end=max;
        for (int i = 1; i < nums.length; i++) {
            max=Math.max(max,i+nums[i]);
            if (i==end){
                step++;
                end=max;
                if (end>len-1) return step;
            }
        }
        return step;
    }
}
