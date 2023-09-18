package LeeCode;

import java.util.Arrays;
import java.util.TreeMap;

public class code1921 {
    public static void main(String[] args) {
        //  你正在玩一款电子游戏，在游戏中你需要保护城市免受怪物侵袭。
        // 给你一个 下标从 0 开始 且长度为 n 的整数数组 dist ，其中 dist[i] 是第 i 个怪物与城市的 初始距离（单位：米）。
        //
        //怪物以 恒定 的速度走向城市。
        // 给你一个长度为 n 的整数数组 speed 表示每个怪物的速度，其中 speed[i] 是第 i 个怪物的速度（单位：米/分）。
        //
        //怪物从 第 0 分钟 时开始移动。
        // 你有一把武器，并可以 选择 在每一分钟的开始时使用，包括第 0 分钟。
        // 但是你无法在一分钟的中间使用武器。这种武器威力惊人，一次可以消灭任一还活着的怪物。
        //
        //一旦任一怪物到达城市，你就输掉了这场游戏。
        // 如果某个怪物 恰 在某一分钟开始时到达城市，这会被视为 输掉 游戏，在你可以使用武器之前，游戏就会结束。
        //
        //返回在你输掉游戏前可以消灭的怪物的 最大 数量。如果你可以在所有怪物到达城市前将它们全部消灭，返回  n 。

        int[] dist={3,5,7,4,5};
        int[] speed={2,3,6,3,2};
        System.out.println(eliminateMaximum(dist, speed));
    }
    //  怪物的速度:  speed[i]   怪物的距离:   dist[i]
    //  求出怪物到达的时间:  dist[i]/speed[i]        :   先击败时间最短的怪物即可
    //  因为怪物到达城市,就会直接失败,即返回

    //这个就又简单,效率又高
    public int eliminateMaximum1(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];//用数组维护时间信息
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(arrivalTimes);//排序
        for (int i = 0; i < n; i++) {
            if (arrivalTimes[i] <= i) return i;//怪兽到了就返回
        }
        return n;
    }


    //排序然后逐个处理,效率不高
    public static int eliminateMaximum(int[] dist, int[] speed) {
        TreeMap<Integer,Integer> minTime=new TreeMap<>();
        for (int i = 0; i < dist.length; i++) {//放入treemap
            int temp= (int) Math.ceil(((double) dist[i])/speed[i]);//向上取整
            if (temp==0) temp=1;//如果速度比距离数字大,就设时间为1
            if (!minTime.containsKey(temp)) minTime.put(temp,1);
            else minTime.put(temp,minTime.get(temp)+1);
        }
        int time=0;//时间
        while (minTime.firstKey()-time!=0){//如果最小的时间到0就停止
            Integer min = minTime.firstKey();//最小时间
            Integer count = minTime.get(minTime.firstKey());//最小时间到达的怪物数量
            if (count==1) minTime.remove(min);//只有一个就消灭
            else minTime.put(min,count-1);//否则消灭一个
            time++;
            if (minTime.isEmpty()) return time;//为空就直接返回
        }
        return time;
    }




}
