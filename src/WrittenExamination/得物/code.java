package WrittenExamination.得物;

public class code {
    public static void main(String[] args) {
        //一个人，写一天作业要休息1天或两天
        //给定数组表示每天写作业的数量，数量随心情不相同
        //求最后一天的最多写多少作业
    }
    //用dp推导即可，dp[i]表示第i天的时候最多写多少作业
    public static int getMaxNum(int[]arr){
        int n=arr.length;
        //因为可以必须休息1天或两天,所以要获得三天的dp情况
        if (n==1) return arr[0];
        if (n==2) return Math.max(arr[0],arr[1]);
        if (n==3) return Math.max(arr[1],arr[0]+arr[2]);
        int[] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        dp[2]=Math.max(arr[1],arr[0]+arr[2]);

        for (int i = 3; i < arr.length; i++) {
            int tmp=arr[i]+Math.max(dp[i-2],dp[i-3]);
            dp[i]=Math.max(dp[i-1],tmp);
        }
        return dp[n-1];

    }
}
