package Leecode2;

public class code42_接雨水 {
    public static void main(String[] args) {
        //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
        int[]arr={2,0,0,0,2};
        System.out.println(trap1(arr));
    }

    //动态规划
    //定义两个数组maxL和maxR分别标注从左到右的最大值和从右到左的最大值，因为只要有了这个就可以确定当前位置i的水高到底是多少
    public static int trap1(int[] height) {
        int len = height.length;
        if (len == 0) return 0;

        int[] maxL = new int[len];
        maxL[0] = height[0];
        int[] maxR = new int[len];
        maxR[len - 1] = height[len - 1];
        int l=1,r=len-2;
        int ans=0;
        int mid=len/2;
        while (l<len){
            maxL[l]=Math.max(maxL[l-1],height[l]);
            maxR[r]=Math.max(maxR[r+1],height[r]);
            if (l>=mid){
                ans += Math.min(maxL[l], maxR[l]) - height[l];
                ans += Math.min(maxL[r], maxR[r]) - height[r];
            }
            l++; r--;
        }
        if (len%2!=0) ans -= Math.min(maxL[mid], maxR[mid]) - height[mid];
        return ans;
    }
    //暴力
    public static int trap(int[] height) {
        int sum = 0;
        int idxL=0,idxR=0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int maxL = 0;
            //找出i左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxL) maxL = height[j];
            }
            int maxR = 0;
            //找出i右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxR) maxR = height[j];
            }
            //找出较小的墙作为当前水高
            int min = Math.min(maxL, maxR);
            //只有水高大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) sum = sum + (min - height[i]);
        }
        return sum;
    }
}
