package LeeCode;

public class code2240 {
    public static void main(String[] args) {
        //给你一个整数 total ，表示你拥有的总钱数。
        // 同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。
        // 你可以花费你部分或者全部的钱，去买任意数目的两种笔。
        //
        //请你返回购买钢笔和铅笔的 不同方案数目 。

        //total = 20, cost1 = 10, cost2 = 5     输出: 9
        //total =100    cost1 =1    cost2 =1    输出: 5151
        //System.out.println(waysToBuyPensPencils(20, 10, 5));
        System.out.println(waysToBuyPensPencils(100, 1, 1));
       // System.out.println(waysToBuyPensPencils(20, 10, 5));
    }
    //ax+by<c (x>=0,y>=0)   a和b是整数,求x和y在二维图中有多少个格子树
    //固定 x,就能得到   y<(c-ax)/b
    //即固定cost1,就可以得到  cost1的最大数量 = (total- cost2 * cost2的数量 )/ cost1

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1<cost2) return waysToBuyPensPencils(total,cost2,cost1);
        long count=0;
        for (int i = 0; i <= total; i++) {
            if (total>=i*cost1) count+=(total - (long) cost1 *i)/cost2+1;
            else break;
        }
        return count;
    }
}
