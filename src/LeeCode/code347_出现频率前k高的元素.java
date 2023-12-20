package LeeCode;

import java.util.*;
import java.util.function.IntFunction;

public class code347_出现频率前k高的元素 {
    public static void main(String[] args) {
        //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    }
    //采用了计数排序/桶排序,这种排序的好处是: 将时间复杂度从n降到了k
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //计数排序
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        //将结果集转位数组
        int tmp=k;
        for (Integer num : res) {
            ans[--k]=num;
        }
        return ans;
    }
}
