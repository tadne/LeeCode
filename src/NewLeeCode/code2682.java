package NewLeeCode;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class code2682 {
    public static void main(String[] args) {
        //n 个朋友在玩游戏。这些朋友坐成一个圈，按 顺时针方向 从 1 到 n 编号。
        // 从第 i 个朋友的位置开始顺时针移动 1 步会到达第 (i + 1) 个朋友的位置（1 <= i < n），
        // 而从第 n 个朋友的位置开始顺时针移动 1 步会回到第 1 个朋友的位置。
        //
        //游戏规则如下：
        //
        //第 1 个朋友接球。
        //接着，将球传给距离他顺时针方向 k 步的朋友。
        //然后，接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友。
        //接着，接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友，以此类推。
        //换句话说，在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友。
        //
        //当某个朋友第 2 次接到球时，游戏结束。
        //
        //在整场游戏中没有接到过球的朋友是 输家 。
        //
        //给你参与游戏的朋友数量 n 和一个整数 k ，请按升序排列返回包含所有输家编号的数组 answer 作为答案。
        //1 <= k <= n <= 50
        System.out.println(Arrays.toString(circularGameLosers(14, 13)));

    }
    public static int[] circularGameLosers(int n, int k) {
        if (n==1) return new int[0];
        Set<Integer> set=new HashSet<>();
        for (int i = 2; i <= n; i++) {//添加
            set.add(i);
        }
        int idx=1+k;//提前取出了第一个人
        int count=2;//次数
        int stop=idx;//要删除的人
        while (set.remove(stop)||stop==0){//删除前面的人或是最后一个人
            if(stop==0&&!set.remove(n)) break;//如果第二层删除最后一个人
            idx+=count*k;
            count++;
            stop=idx%n;
        }
        int [] result = new int[set.size()];
        count=0;
        for (Integer integer : set) {
            result[count++] = integer;
        }
        return result;
    }
}
//1  2  4  7  11  16  22   29  37
//1  2  4  7  11  4   10   5   1
//3, 6, 8, 9, 12
//3,5,6,8,9,10,12
