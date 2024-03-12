package LeeCode;

import java.util.Arrays;

public class code455_分发饼干 {
    public static void main(String[] args) {
        //要给你的孩子们一些小饼干。但每个孩子最多只能给一块。
        //对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
        // 并且每块饼干 j，都有一个尺寸 s[j] 。
        // 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
    }
    //排序
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);Arrays.sort(s);//排序
        int res=0;
        for (int i = 0,j=0; i < s.length&&j<g.length; ) {
            if (s[i]>=g[j]) {//满足胃口,
                res++;
                i++;j++;
            }else {//不满足胃口,找下一块饼干
                i++;
            }
        }
        return res;
    }
}
