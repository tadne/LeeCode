package WrittenExamination.核桃;

import java.util.HashMap;
import java.util.Map;

public class 最少人数 {
    public static void main(String[] args) {
        //nums[i]表示和第i个人相同分数的人数
        //求至少有多少人参加比赛
        System.out.println(getMin(new int[]{1,2,3,3,3,3,3,3}));//2+3+4+4
    }

    public static int getMin(int[]nums){
        int len=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if (map.get(num)==num+1){
                res+=num+1;
                map.remove(num);
            }
        }
        for (Integer integer : map.keySet()) {
            res+=integer+1;
        }
        return res;
    }
}
