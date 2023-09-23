package LeeCode;

public class code11 {
    public static void main(String[] args) {
        //给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
        //
        //找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        //
        //返回容器可以储存的最大水量。
        int[] arr={2,3,10,5,7,8,9};
        System.out.println(maxArea(arr));
    }
    //双指针
    public static int maxArea(int[] height) {
        int len=height.length;
        int max=0;
        int l=0,r=len-1;
        for (int i = 0; i < len; i++) {
            if (height[l]>height[r]){//如果左右两边不相等,那么先移动小的,因为小的决定了水量,大的即使变大也不影响水量
                max = Math.max(max, height[r] * (r - l ));
                r--;
            }else {
                max = Math.max(max, height[l] * (r - l ));
                l++;
            }
        }
        return max;
    }
}
