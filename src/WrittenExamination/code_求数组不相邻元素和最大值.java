package WrittenExamination;

public class code_求数组不相邻元素和最大值 {
    public static void main(String[] args) {
        //给定一个正数组成的数组,选择一些数字,这些数字不能相邻
        //其中,数组的第一个数字和最后一个数字相邻
        //求这类数字的最大和

        int[]arr={10,3,2,5,7,12,11};
        System.out.println(maximizeDonations(arr));
    }
    //将数组分为两部分,一部分是0==>n-1 ,另一部分是1==>n
    //分别找到不相邻元素和的最大值,取两者最大即可
    public static int maximizeDonations (int[] donations) {
        // write code here
        int len=donations.length;
        if (len==0) return 0;
        else if (len==1) return donations[0];
        else if (len==2) return Math.max(donations[0],donations[1]);
        return Math.max(getMax(donations,0),getMax(donations,1));
    }
    //获取数组不相邻元素最大值
    //用dp数组递推, dp[] :   表示数组从索引为0开始的不相邻元素和的最大值
    // 可以得到  dp[i]=Math.max(arr[i]+arr[i-2],dp[i-1])
    public static int getMax(int[] arr,int idx){
        int len = arr.length-1;
        int[] dp=new int[len];
        dp[0]=arr[idx];
        dp[1]=Math.max(arr[idx],arr[idx+1]);
        for (int i = 2; i < len; i++) {
            int a=arr[i+idx]+dp[i+idx-2];
            int b=dp[i-1];
            dp[i]=Math.max(a,b);
        }
        return dp[len-1];
    }


}
