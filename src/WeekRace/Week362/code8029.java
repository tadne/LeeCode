package WeekRace.Week362;

import java.util.ArrayList;
import java.util.List;

public class code8029 {
    public static void main(String[] args) {
        //给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。
        // 对于任意下标 i，nums[i] = [starti, endi] ，其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
        //
        //返回数轴上被车 任意部分 覆盖的整数点的数目。
        //
        // 1 <= nums.length <= 100
        //nums[i].length == 2
        //1 <= starti <= endi <= 100

        //12 17  23 46 5+6-5
        //
    }
    public int numberOfPoints(List<List<Integer>> nums) {
        int [] ans=new int[101];
        int res=0;
        for (List<Integer> num : nums) {
            for (int j = num.get(0); j < num.get(1) - num.get(0); j++) {
                ans[j] = 1;
            }
        }
        for (int an : ans) {
            if (an == 1) res++;
        }
        return res;
    }

}
