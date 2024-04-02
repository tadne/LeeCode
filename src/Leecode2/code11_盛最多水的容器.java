package Leecode2;

public class code11_盛最多水的容器 {
    public static void main(String[] args) {
        //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
        //
        //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        //
        //返回容器可以储存的最大水量。
    }
    //数学，双指针
    public int maxArea(int[] height) {
        int maxArea=0;
        int l=0,r=height.length-1;
        while (r>l){
            //如果两个不一样高就先移动小的，因为小的决定了水的高度
            if (height[l]>height[r]){
                maxArea=Math.max(maxArea,(r-l)*height[r--]);
            }else {
                maxArea = Math.max(maxArea, (r - l) * height[l++]);
            }
        }
        return maxArea;
    }
}
