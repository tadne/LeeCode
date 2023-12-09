package LeeCode;

public class code292_Nim游戏 {
    public static void main(String[] args) {
        //Nim 游戏：
        //桌子上有一堆石头。
        //两人轮流进行自己的回合， 你作为先手 。
        //每一回合，轮到的人拿掉 1 - 3 块石头。
        //拿掉最后一块石头的人就是获胜者。
        //假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
        System.out.println(canWinNim(5));
    }
    //动态规划,如果已经拿了第dp[n]表示剩余的石头数量,n%2=1就是对方,否则就是自己
    //先了解游戏,剩1,2,3块先手赢,
    //还剩下4块的时候,先手输
    //还剩5,6,7块的时候,先手赢
    //还剩8块的时候,先手输
    //剩9,10,11,先手赢
    //当然还可以以此类推
    //总结: 每隔3块结果出现变化,也就是 true,true,true,false 的无限循环.
    public static boolean canWinNim(int n) {
        return n%4>0;
    }
}
