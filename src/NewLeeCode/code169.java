package NewLeeCode;

import java.util.HashMap;
import java.util.HashSet;

public class code169 {
    public static void main(String[] args) {
        //给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
        //
        //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    }
    //由于题目条件,可以知道,有一个元素数量比其他元素数量加起来都多
    public int majorityElement1(int[] nums) {
        int res=nums[0];//不妨设第一个元素为最多元素
        int count=1;//记录个数
        for (int i = 1; i < nums.length; i++) {
            if (res==nums[i]) count++;//如果相同,计数+1
            else if (count==0&&res!=nums[i]){//如果计数为0时,说明它现在不是最多元素,换掉它为当前最多
                res=nums[i];
                count++;
            } else count--;//如果不同,计数-1
        }
        return res;

    }
    //map计数
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int key=nums[i];
            if (!map.containsKey(key)) map.put(key,1);
            else {
                map.put(key, map.get(key) + 1);
                if (map.get(nums[i])>n/2) return key;
            }
        }
        return nums[0];
    }
}
