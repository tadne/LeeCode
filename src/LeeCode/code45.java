package LeeCode;

public class code45 {
    public static void main(String[] args) {
        //给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
        //
        //每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
        //
        //0 <= j <= nums[i]
        //i + j < n
        //返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
    }
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int len = nums.length;
        int maxPosition = nums[0];///当前位置下的能跳到的最大位置
        int end = maxPosition;//当前遍历的末尾
        int step = 1;
        for (int i = 1; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);//找最大跳跃位置
            if (i == end) {//在能调到的地方遍历并已经找到最大位置
                end = maxPosition;//刷新遍历末尾位置
                step++;
                if(end>len-1) return step;//剪枝
            }
        }
        return step;
    }
}
