package Leecode2;

public class code134_加油站 {
    public static void main(String[] args) {
        //在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
        //
        //你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
        //
        //给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
        int[]gas = {3,1,1}, cost = {1,2,2};
        System.out.println(canCompleteCircuit1(gas, cost));
    }

    //贪心，因为可以发现，如果从 t1点开始，tn点就没油了，那么中间的节点肯定也是不能到达的，可以直接从tn+1开始计算了
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        int idx = 0;
        while (idx < len) {//每一个元素都遍历
            int sum=0;
            int count = 0;
            while (count < len) {//控制每次遍历长度为n
                int j = (idx + count) % len;
                sum += gas[j]- cost[j];
                if (sum < 0) break;
                count++;
            }
            if (count == len) return idx;//如果长度达到,就说明成功转了一圈
            else idx += count + 1;//重新选起点
        }
        return -1;
    }

}
