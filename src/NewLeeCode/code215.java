package NewLeeCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class code215 {
    public static void main(String[] args) {
        //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
        //
        //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
        //
        //你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

        //[3,2,1,5,6,4], k = 2  输出: 5
        //[3,2,3,1,2,4,5,5,6] k = 4 输出: 4
        int[] arr={3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));


    }
    public static int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }
    static int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];//结束条件
        int x = nums[l], i = l - 1, j = r + 1;//x是基准点,i和j是双指针
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickselect(nums, l, j, k);//决定分区范围
        else return quickselect(nums, j + 1, r, k);
    }
    //这个题我是真头疼,不过总算搞明白了,并且会以后会逐步更新一些基础算法,比如这次的快速排序

    public static int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);//添加前k个元素
        }
        for (int i = k; i < len; i++) {//遍历
            Integer topElement = minHeap.peek();//遍历查看堆中元素
            // 只要当前元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topElement) {
                minHeap.poll();//弹出元
                minHeap.offer(nums[i]);//添加元
            }
        }
        return minHeap.peek();
    }

//    作者：liweiwei1419
//    链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/19607/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
