package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class code46_全排列 {
    public static void main(String[] args) {
       //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
        int[] nums={1,2,3};
        System.out.println(permute1(nums));
    }
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Arrays.stream(nums).forEach(output::add);//提前填入数据
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) res.add(new ArrayList<>(output));//说明
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/permutations/solutions/218275/quan-pai-lie-by-leetcode-solution-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }
    private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int[] visited) {
        if (list.size() == nums.length) {//当前满足条件,可以添加
                res.add(new ArrayList<>(list));
                return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;//当前元素添加过了
            visited[i] = 1;//给个可以添加的标记
            list.add(nums[i]);//添加
            backtrack(res, nums, list, visited);//再添加下一个元素
            visited[i] = 0;//如果添加到下一个正确集合了,就将上一个元素的添加标记再次改成未添加
            list.remove(list.size() - 1);//然后再退出上一个状态
        }
        //举个栗子,比如nums={1,2,3};
        //i=0,list添加元素1,添加后,进入第二个backtrack
        //i=1,第二个backtrack,这时,list添加第二个元素2,进入第三个backtrack
        //i=2,list添加第三个元素3,进入第四backtrack,这时集合满了,           可以放到res里了,直接return返回到   第三  backtrack
        //i=2,第三backtrack,让visited[2]=0,删去第三元素3,第三backtrack结束,返回第二backtrack
        //i=1,第二backtrack,让visited[1]=0,删去第二元素2
        //i=2,第二backtrack,list添加元素3,进入第五backtrack
        //i=1,第五backtrack,list添加元素2,进入第六backtrack,  此时集合满了,直接返回第五backtrack
        //i=1,第五backtrack,让visited[1]=0;删除第三元素2
        //i=2,第五backtrack,此时visited[1]=1,第五backtrack结束,返回第二backtrack
        //i=2,第二backtrack,让visited[2]=0,删除第二元素3
        //第二backtrack结束,返回第一backtrack
        //i=0,第一backtrack,让visited[0]=0,删除第一元素1
        //i=1,第一backtrack,....重复
    }

}
