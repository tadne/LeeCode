package LeeCode;

import java.util.Arrays;

public class code247 {
    public static void main(String[] args) {
        //给 你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
        //
        //  根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
        // 一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。
        // 如果 h 有多种可能的值，h 指数 是其中最大的那个。
        System.out.println(hIndex1(new int[]{3,0,6,1,5}));
    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);//给论文引用数排序
        int len = citations.length;
        int i=0;
        for (; i < len; i++) {//从后往前遍历先找大引用量的论文,如果发现当前论文的被引用数已经小于等于论文数目了,就停下来
            if (citations[len-i-1]<=i) break;
        }
        return i;//i是遍历顺带的计数
    }
    public static int hIndex1(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];//计数，counter[i] 表示 i 个引用的论文数
        for (int citation : citations) {
            if (citation >= n) {//如果超过总个数要单独计算
                counter[n]++;
            } else counter[citation]++;
        }
        for (int i = n; i >= 0; i--) {//从后往前遍历,因为要从被引用数多的开始加
            tot += counter[i];
            if (tot >= i) return i;//如果当前论文数大于等于当前被引用数,就返回被引用数
        }
        return 0;
    }

}
