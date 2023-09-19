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
        int[] cost = {3,4,5,1,2};//  0 -2  -2  3  3
        //dp: 0 -2 -4 5 0
        System.out.println(canCompleteCircuit2(gas, cost));
    }
    //这个题的关键
    // 1:  数组成环
    // 2:  一条不合适的区间,它的任何一个点都不合适     也就是说,如果一个区间走不同,那么这个区间可以直接跳过

    //最好是用数组做一个环,再用长度控制就会很方便
    //数组成环就用  余数,  (开始索引+遍历的长度)  % 数组的长度
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {//每一个元素都遍历
            int sum=0;
            int count = 0;
            while (count < n) {//控制每次遍历长度为n
                int j = (i + count) % n;
                sum += gas[j]- cost[j];
                if (sum < 0) break;//如果当前消耗大于当前油量
                count++;
            }
            if (count == n) return i;//如果长度达到,就说明成功转了一圈
            else i = i + count + 1;//否则就说明转不了一圈,重新选起点
        }
        return -1;
    }
    //两个指针控制,速度最快,但是中间比较繁琐
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int len=gas.length;
        if (len==1) return gas[0]>=cost[0]?0:-1;
        int i=0,j=0;//双指针
        while (i < len) {
            int sum=0,count=0;//记录大小和步长
            if (gas[i]<=cost[i]) {
                i++;j=i;//油不够时,j要跟着i
                continue;
            }
            while (j < len) {
                sum+=gas[j]-cost[j];
                if (sum<0) {
                    i+=count+1;j=i;//当从i开始到j的这段路不通时,说明这段路任何一个起点都不通
                    break;
                }
                count++;j++;//如果通了,步长+1,右指针+1
                if (j==len) j=0;//成环回原点
                if (j==i) return i;//到达直接返回
            }
        }
        return -1;
    }

    //暴力破解,速度很慢
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len=gas.length;
        if (len==1) return gas[0]>=cost[0]?0:-1;
        int i=0;
        for (; i < len; i++) {
            if (gas[i]<=cost[i]) continue;
            int curGas=0;
            for (int j = i; j < len; ) {
                curGas+=gas[j]-cost[j];
                if (curGas<0) break;
                j++;
                if (j==len) j=0;
                if (j==i) return i;
            }
        }
        return -1;
    }
}
