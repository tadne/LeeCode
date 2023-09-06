package NewLeeCode;

import java.util.ArrayList;
import java.util.List;

public class code78 {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
        //
        //解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

        int [] arr={1,2,3};
        System.out.println(subsets(arr));
        List<Integer> list=new ArrayList<>();


    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());//size=1
        //[]
        //[],[1]
        //[],[1],[2],[1,2]
        //[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));//让tmp为前一轮的元素加上当前一个元素,即每一轮都是前一轮元加当前一个元
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }










    static    List<Integer> temp = new ArrayList<Integer>();
    static   List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> subsets1(int[] nums) {
        for (int i = 0; i < nums.length+1; i++) {
            dfs(1,nums,i);
        }
        return ans;
    }
    public static void dfs(int cur, int[] nums, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        int n=nums.length;
        if (temp.size() + (n- cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(nums[cur-1]);
        dfs(cur + 1, nums, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, nums, k);
    }




}
