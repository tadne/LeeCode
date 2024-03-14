package LeeCode;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class code447_回旋镖的数量 {
    public static void main(String[] args) {
        //给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
        // 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的欧式距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
        //
        //返回平面上所有回旋镖的数量。
    }

    //关键在于点与点之间的距离
    //这时候,可以发现,这个题只能遍历求出所有点之间的距离,不然无法进行...
    //我们固定一个点,如果我们知道有哪些点和它距离相等,那就可以使用排列数来计算这个点为中心的回旋镖的数量
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] point1 : points) {
            //key:点j到点i的距离,val:数量
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] point2 : points) {
                int dis = (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Integer integer : map.keySet()) {
                int val = map.get(integer);
                if (val > 1) {
                    res += val * (val - 1) * 0.5;
                }
            }
        }
        return res;
    }


}
