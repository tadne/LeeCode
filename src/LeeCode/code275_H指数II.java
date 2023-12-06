package LeeCode;

public class code275_H指数II {
    public static void main(String[] args) {
        //给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
        //
        //h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）至少 有 h 篇论文分别被引用了至少 h 次。
        //
        //请你设计并实现对数时间复杂度的算法解决此问题。
        int []arr={0,1,3,5,6};
        System.out.println(hIndex(arr));
    }
    //二分查找 O(logn)
    public static int hIndex1(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= n - mid) r = mid - 1;//有n-mid篇论文至少被引用了citation[mid]次
            else l = mid + 1;
        }
        return n - l;
    }
    //直接遍历 O(n)
    public static int hIndex(int[] citations) {
        int res=0,num= citations.length;
        for (int citation : citations) {
            if (res < citation && num > res) res=Math.min(num,citation);
            num--;
        }
        return res;
    }

}
