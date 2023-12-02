package LeeCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code229_多数元素 {
    public static void main(String[] args) {
        //给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    }
    //简单哈希处理
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num)==len/3+1)  res.add(num);
        }
        return res;
    }

    //另一个思路，就是使用摩尔投票法，这里是找到数量大于n/3的元素的数量
    //只要将每三个互不相同的元素互相抵消，那么如果数组中存在数量超过n/3的元素,那最后剩下的元素就可能是数量大于n/3的
    public List<Integer> majorityElement1(int[] nums) {
        int element1 = 0,element2 = 0;//最多有两个超过n/3数量的元素
        int vote1 = 0, vote2 = 0;//记录投票数量
        for (int num : nums) {
            if (vote1 > 0 && num == element1) { //如果该元素与第一个元素相同，投票
                vote1++;
            } else if (vote2 > 0 && num == element2) { //如果该元素与第二个元素相同，投票
                vote2++;
            } else if (vote1 == 0) { // 第一个元素
                element1 = num;
                vote1++;
            } else if (vote2 == 0) { // 第二个元素
                element2 = num;
                vote2++;
            } else { //如果三个元素均不相同，则相互抵消1次投票
                vote1--;
                vote2--;
            }
        }
        // 检测元素出现的次数是否满足要求
        int cnt1 = 0,cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) cnt1++;
            if (vote2 > 0 && num == element2) cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) ans.add(element1);
        if (vote2 > 0 && cnt2 > nums.length / 3) ans.add(element2);
        return ans;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/majority-element-ii/solutions/1058790/qiu-zhong-shu-ii-by-leetcode-solution-y1rn/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
