package WeekRace.Week364;

import java.util.List;

public class code100048 {
    public static void main(String[] args) {
        //给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
        //你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i]
        //如果以下条件满足，我们称这些塔是 美丽 的：

        //1 <= heights[i] <= maxHeights[i]
        //对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]          //山峰左边      单增
        //对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]      //山峰右边      单减

        //请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
        //1 <= n == maxHeights <= 10^5
        //1 <= maxHeights[i] <= 10^9
    }
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long max=0;
        int len=maxHeights.size();
        for (int i = 0; i < len; i++) {
            if (i>0&&maxHeights.get(i)<=maxHeights.get(i-1)) continue;//只有区间最大值才可能是最大山峰
            else if (i<len-1&&maxHeights.get(i+1)>maxHeights.get(i))continue;
            int[] tmpMH=new int[len];
            for (int j = 0; j < tmpMH.length; j++) {
                tmpMH[j]=maxHeights.get(j);
            }
            int l=i-1,r=i+1;
            long sum=maxHeights.get(i);
            while (l>=0){
                if (tmpMH[l+1]<tmpMH[l])tmpMH[l]=tmpMH[l+1];//后大于前,加前
                sum+=tmpMH[l];
                l--;
            }
            while (r<len){
                if (tmpMH[r]>tmpMH[r-1])tmpMH[r]=tmpMH[r-1];//前大于后,加后
                sum+=tmpMH[r];
                r++;
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}
