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
    public static int jump1(int[] nums) {//如果我们按照权重来看，显然后一位的权重比前一位大1，以此为基
        int len = nums.length;//长度
        int end = 0;//跳跃位置
        int maxIndex = 0;//最大位置
        int step = 0;//跳跃次数
        for (int i = 0; i < len - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == end) {//如果到了最大位置，就跳跃。其中第一次跳跃是无条件的，因为要避免到达n-1的时候的跳跃
                end = maxIndex;
                step++;
            }
        }
        return step;
    }

    public static int jump2(int[] nums) {
        if (nums.length==1) return 0;
        if (nums.length==2) return 1;
        int maxIndex=0;
        int time=0;
        while (maxIndex+nums[maxIndex]<=nums.length-1){
            if (nums[maxIndex]==1) {
                maxIndex++;
                time++;
                continue;
            }
            int max=nums[maxIndex+1]+1;
            int temp=maxIndex;
            maxIndex=maxIndex+1;
            for (int j = 1; j+maxIndex < nums.length&&j<=nums[temp]; j++) {
                if (max<nums[maxIndex+j]+j){
                    max=nums[maxIndex+j]+j;
                    maxIndex=maxIndex+j;
                }
            }
            // System.out.println(maxIndex);
            time++;
        }
        return time;
    }
}
