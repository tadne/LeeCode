package NewLeeCode;

import java.util.*;

public class code822 {
    public static void main(String[] args) {
        //在桌子上有 n 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。
        //我们可以先翻转任意张卡片，然后选择其中一张卡片。
        //如果选中的那张卡片背面的数字 x 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。
        //哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0 。
        //其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。
        //如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。
        System.out.println(flipgame(new int[]{1, 1}, new int[]{1, 2}));
        //1 <= fronts[i], backs[i] <= 2000
    }
    //脑筋急转弯题
    //其实很简单,就是说,如果有一张牌,正反都一样,那么,这张牌的数字怎么都不可能唯一
    //反之,如果正反不一样,那么一定可以通过翻转做到唯一

    //也就是说,只有去除所有和正反重复牌的相同的数字
    //然后找到其中最小值即可

    public int flipgame1(int[] fronts, int[] backs) {
        HashSet<Integer> forbidden = new HashSet<Integer>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) forbidden.add(fronts[i]);
        }
        int ans = 3000;
        for (int x : fronts) if (!forbidden.contains(x)) ans = Math.min(ans, x);
        for (int x : backs)  if (!forbidden.contains(x)) ans = Math.min(ans, x);
        return ans == 3000 ? 0 : ans;
    }

    public static int flipgame(int[] fronts, int[] backs) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i]==backs[i]) list.add(fronts[i]);
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (list.contains(fronts[i])) fronts[i]=min;
            if (list.contains(backs[i])) backs[i]=min;
            int temp=Math.min(fronts[i],backs[i]);
            min=Math.min(min,temp);
        }
        return min==Integer.MAX_VALUE?0:min;
    }


}
