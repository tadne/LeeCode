package NewLeeCode;

public class code300 {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
        //
        //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    }

    //这个题一开始很难理解,但是相通了就会觉得还可以
    //第二种方法关键就是维护这个数组   长度为 i 的最长上升子序列的末尾元素的最小值


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;//最短长度为1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//如果当前值大于j位置的值,就说明,它比子序列所有值大,就可以添加到子序列后面,取dp中那个子序列+1即可
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    //tails[i]，表示长度为 i 的最长上升子序列的末尾元素的最小值，用 len 记录目前最长上升子序列的长度
    //其中的关键就是   tails[i]表示长度为i的最长子序列的末尾元素的最小值
    //一旦找到不满升序的值,就往前看看有没有比这值大的元素,直接替换
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            //如果不对称,就说明出现逆序了,开始查之前的tails中0~res-1的元素来保证tails定义  长度为 i 的最长上升子序列的末尾元素的最小值
            // 这样才能保证后面要添加的元素合适插入
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;

//        作者：Krahets
//        链接：https://leetcode.cn/problems/longest-increasing-subsequence/solutions/24173/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

}
