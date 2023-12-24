package LeeCode;

import java.util.*;

public class code368_最大整除子集 {
    public static void main(String[] args) {
        //一个由 无重复 正整数组成的集合 nums ，请找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应满足：
        //answer[i] % answer[j] == 0 或 answer[j] % answer[i] == 0
        //如果存在多个有效解子集，返回其中任何一个均可。

        //1 <= nums.length <= 1000
        //1 <= nums[i] <= 2 * 10^9
        //nums 中的所有整数 互不相同
        int[]arr={5,9,18,54,108,540,90,180,360,720};
        System.out.println(largestDivisibleSubset(arr));
    }

    public List<Integer> largestDivisibleSubset1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];//维护当前整除子集的最大长度
        int[] g = new int[n];//维护整除子集的在nums中的索引,通过图的形式
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            g[i] = prev;
        }

        // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }

        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
//    作者：宫水三叶
//    链接：https://leetcode.cn/problems/largest-divisible-subset/solutions/738882/gong-shui-san-xie-noxiang-xin-ke-xue-xi-0a3jc/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





    //以下方法超时,o(╥﹏╥)o
    //找最大整除子集
    //那思路来说,我们知道最小公倍数的可以整除它的所有因子
    //再进一步,我们发现,我们其实要不断找到结果集合的最小公倍数,这会是我们必须要维护的
    //如果我们知道了集合的最小公倍数,那么添加新元素的时候,只有这个元素可以整除它,就添加,并将最小公倍数更新为新元素
    //接下来,我们要考虑的是,怎样才能考虑完全所有可能性
    //采用最小公倍数方式得到的集合是基于基数的,这个基数是集合的第一个非1的数!
    //借此,我们可以按这个数的不同来做出判断
    //如果这个数不是之前判断过的数的倍数,那就要去查找结果集
    //其实我们可以得到的结果集去剔除即可
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        List<Integer> res=new ArrayList<>();
        int size=0,idx=-1;
        int i = 0;
        if (nums[0]==1) set.add(1);
        for (int num : nums) {
            if (!set.contains(num)){
                List<Integer> tmp = largestDivisibleSubset(nums,num,new ArrayList<>(),0);
                if (tmp.size()>size) {
                    size=tmp.size();
                    res=tmp;
                }
                set.addAll(tmp);
            }
        }
        if (nums[0]==1) res.add(1);
        return res;
    }

    //查找结果集
    //问题,举例:  9,18,54,90,108,180,360,540,720 :  在遇到最小公倍数 54 和 90,如果跳过54选择90,那么就能得到更有效的结果集
    //通常我们通过
    public static List<Integer> largestDivisibleSubset(int[] nums,int mul,List<Integer> res,int idx){
        if (idx==nums.length) return res;
        if (nums[idx]%mul==0) {
            List<Integer> res1 = largestDivisibleSubset(nums, mul, new ArrayList<>(res), idx + 1);
            res.add(nums[idx]);
            mul=nums[idx];
            List<Integer> res2 = largestDivisibleSubset(nums, mul, res, idx + 1);
            return res1.size()>res2.size()? res1:res2;
        }else return largestDivisibleSubset(nums,mul,res,idx+1);
    }

}
