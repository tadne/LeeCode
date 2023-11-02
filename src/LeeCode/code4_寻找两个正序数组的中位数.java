package LeeCode;

public class code4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
        //
        //算法的时间复杂度应该为 O(log (m+n))
        int[]arr1={1,2};
        int[]arr2={3,4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length;
        int left = (n + m + 1) / 2,right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    //方法的作用是找到第k个最小值
    //  通过递归循环来不断剔除前面的元素
    //  其中k是不断变动减小的,初始值是中位数,每剔除一个,就减小1,start就增加1
    //  剔除方式:   取得两个数组的第 k/2 个元素 a1 和 a2 ,将a1 , a2 中小的那个数组的前面部分剔除
    //      例:      1245  134   取k=4,那a1=2 a2=3 ,a1<a2,所以剔除 数组1的12两个数组,k-=2,start1+=2;
    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1,len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        //如果是空就直接返回
        if (len1 == 0) return nums2[start2 + k - 1];
        //如果要找的数是第一个最小的数,就可以直接返回了
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        //i和j分别是两个数组可能要剔除的长度
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {//比较两个数组的第start+k/2个元素,如果大于说明该剔除nums2
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {//小于就是剔除nums1
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

//    作者：windliang
//    链接：https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/8999/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
