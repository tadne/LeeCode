package Leecode2;

import java.util.Arrays;

public class code274_H指数 {
    public static void main(String[] args) {
        //给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
        //
        //根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
        // 并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个
        int[]arr=new int[]{1000,1};
        System.out.println(hIndex1(arr));
    }
    //排序加后序遍历，只要之前遍历的论文引用数目大于当前论文，并且当前论文引用数大于h，就可以h++
    public int hIndex(int[] citations) {
        int h=1;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i]>h) h++;
            else return h;
        }
        return h;
    }
    //m表示0~i论文的h指数,i+1论文的引用数为n
    //如果m>=n,说明指数不变
    //如果m<n,要验证之前i篇论文中，此时要知道前i篇中被引用次数等于h的论文的数量count，
    // 如果cont==0,h++
    // 如果count>=1，h不变
    public static int hIndex1(int[] citations) {
        //记录引用次数大于n的论文数量
        int[] record=new int[citations.length+1];
        for (int citation : citations) {
            if (citation > citations.length)
                record[citations.length] ++;
            else
                record[citation] ++;
        }
        //后序遍历，找到论文数量 i 和 引用次数相契合的值
        for(int i=citations.length;i>=0;i--){
            if(i<=record[i]){
                return i;
            }
            record[i-1]+=record[i];
        }
        return -1;
    }
}
