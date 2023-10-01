package LeeCode;

import java.util.HashSet;
import java.util.Set;

public class code202_快乐数 {
    public static void main(String[] args) {
        //编写一个算法来判断一个数 n 是不是快乐数。
        //
        //「快乐数」 定义为：
        //
        //对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        //然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        //如果这个过程 结果为 1，那么这个数就是快乐数。
        //如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
    }
    //这个快乐数的计算只有两种可能
    //1:    最终结果为1
    //2:    最终结果重复成环
    //原因:   ...难以证明
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while (true){
            if (n==1) return true;
            else if (!set.add(n)) return false;//如果成环了就不可能为1
            n=getSumOfSquared(n);
        }
    }
    public int getSumOfSquared(int n){//计算平方和
        int sum=0;
        while (n!=0){
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }


}
