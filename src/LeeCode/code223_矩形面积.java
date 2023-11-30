package LeeCode;

public class code223_矩形面积 {
    public static void main(String[] args) {
        //给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
        //
        //每个矩形由其 左下 顶点和 右上 顶点坐标表示：
        //
        //第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
        //第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
    }
    //ax1 ay2    ax2 ay2
    //ax1 ay1    ax2 ay1
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //计算两个矩形面积
        int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
        //计算重叠面积的长和宽
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1), overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        //计算重叠面积
        int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
        //返回
        return area1 + area2 - overlapArea;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/rectangle-area/solutions/1024639/ju-xing-mian-ji-by-leetcode-solution-xzbl/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
