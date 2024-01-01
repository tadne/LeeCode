package LeeCode;

public class code390_消除游戏 {
    public static void main(String[] args) {
        //列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
        //
        //从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
        //重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
        //不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
        //给你整数 n ，返回 arr 最后剩下的数字。
    }

    //实际上消除找的是数组的索引,而不是数字, 123 和 456经过消除的结果的索引是一致的
    //也就是说,不仅仅会和奇偶相关还和正反相关
    //如果是奇数个,那么正反不影响
    //如果是偶数个,那么正的不影响,反的要减一      例如: 13=2*f(2)-1和24=2*f(2)的反消除结果是 1 和 2
    //动态规划
    public int lastRemaining(int n) {
        return geta(n);
    }
    public int geta(int n){//正
        if (n==1) return 1;
        return 2*getb(n/2);
    }
    private int getb(int n) {//反
        if (n==1) return 1;
        int tmp= n%2==0? 1:0;
        return 2*geta(n/2)-tmp;
    }
}
