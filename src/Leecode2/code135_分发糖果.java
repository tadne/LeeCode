package Leecode2;

public class code135_分发糖果 {
    public static void main(String[] args) {
        //n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
        //
        //你需要按照以下要求，给这些孩子分发糖果：
        //
        //每个孩子至少分配到 1 个糖果。
        //相邻两个孩子评分更高的孩子会获得更多的糖果。
        //请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
    }
    //发糖果有两种情况，一种是左边的分大于右边，一种是右边的分大于左边
    //我们可以先从左到右发，再从右到左发,最终将其中发的多的的作为糖果分发的结果
    //因为，如果是单调的一段序列，那肯定会出现首部或者尾部有一个糖果特别多的人，但是如果只遍历一个方向是也可能错过它们的
    public int candy(int[] ratings) {
        int sum=0;
        int len=ratings.length;
        int[] left=new int[len];
        for (int i = 0; i < len; i++) {
            if (i>0&&ratings[i]>ratings[i-1]) left[i]=left[i-1]+1;
            else left[i]=1;
        }
        int right=0;
        for (int i = len - 1; i >= 0; i--) {
            if (i<len-1&&ratings[i]>ratings[i+1]){
                right++;
            }else right=1;
            sum+=Math.max(left[i],right);
        }
        return sum;
    }

}
