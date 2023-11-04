package LeeCode;

import java.util.*;

public class code373_查找和最小的k对数字 {
    public static void main(String[] args) {
        //给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
        //
        //定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
        //
        //请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
        //1 <= nums1.length, nums2.length <= 105
        //-10^9 <= nums1[i], nums2[i] <= 10^9
        //nums1 和 nums2 均为升序排列
        //1 <= k <= 10^4
        int[]nums1 = {1,1,11}, nums2 = {1,7,6};
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->
             nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]
        );//创建优先队列,长度为k,队列中储存的是索引对,从小到大排列,排序方式是 按照真实对数和大小排序
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length,n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {//将前k个索引数对加入队列,避免重复
            pq.offer(new int[]{i,0});
        }
        //每次添加一个索引对(ai,bi),下一次有两种选择(ai+1,bi)和(ai,bi+1),其中(ai+1,bi)已经添加,只需再加上(ai,bi+1)即可
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            ans.add(List.of(nums1[idxPair[0]],nums2[idxPair[1]]));
            if (idxPair[1] + 1 < n) {//边界条件
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});//添加下一种可能
            }
        }
        return ans;
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solutions/1208350/cha-zhao-he-zui-xiao-de-kdui-shu-zi-by-l-z526/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

}
