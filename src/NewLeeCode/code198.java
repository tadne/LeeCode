package NewLeeCode;

public class code198 {
    public static void main(String[] args) {
        //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
        // 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
        // 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
        //输入：[1,2,3,1]      输出：4
        //输入：[2,7,9,3,1]    输出：12
        //输入：[20,4,3,30,1]    输出：12
        //给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    }
    //假设有k个房间
    //偷第k个房间代表不能偷第k-1个
    //那么,是否偷第k个房间,取决于   偷前k-2个房间获取的最多钱+第k个房间的钱   与    偷前k-1个房间的最多钱   中的最大值
    //用dp[i]数组表示,前i个房间偷取的最多钱
    //  dp[i]=Math.max(  dp[i-2] + nums[i]  ,  dp[i-1] )
    public int rob(int[] nums) {
        int len=nums.length;
        if (len==1) return nums[0];
        int [] dp=new int[len];
        dp[0]=0;
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);//偷k等价与不偷k-1,就是说比较nums[k]+前k-2的最大钱与前k-1的最大钱比较
        }
        return dp[len-1];
    }

    //因为只需要使用dp空间中的倒数第二三项
    //所以直接动态保存节约空间,用双指针
    public int rob1(int[] nums) {
        int len=nums.length;
        if (len==1) return nums[0];
        int l=nums[0];
        int r=Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            int temp=r;
            r=Math.max(l+nums[i],r);
            l=temp;
        }
        return r;
    }
}
