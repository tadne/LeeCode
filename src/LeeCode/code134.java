package LeeCode;

public class code134 {
    public static void main(String[] args) {
        //在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
        //
        //你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
        // 你从其中的一个加油站出发，开始时油箱为空。
        //
        //给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
        // 如果存在解，则 保证 它是 唯一 的。
        int[] gas = {1,2,3,4,5};
        int[] cost = {39,4,5,1,2};//  -2 -2  -2  3  3
        System.out.println(canCompleteCircuit(gas, cost));
    }
    //最好是用数组做一个环,再用长度控制就会很方便
    //数组成环就用  余数,  (开始索引+遍历的长度)  % 数组的长度


    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {//每一个元素都遍历
            int sumOfGas = 0, sumOfCost = 0;
            int count = 0;
            while (count < n) {//控制每次遍历长度为n
                int j = (i + count) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) break;//如果当前消耗大于当前油量
                count++;
            }
            if (count == n) return i;//如果长度达到,就说明成功转了一圈
            else i = i + count + 1;//否则就说明转不了一圈,重新选起点
        }
        return -1;
    }

}
