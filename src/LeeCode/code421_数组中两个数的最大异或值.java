package LeeCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class code421_数组中两个数的最大异或值 {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
        System.out.println(findMaximumXOR(new int[]{3, 10, 7, 27, 2, 8}));
    }
    // 1+1=0
    // 1+0=1
    public static int findMaximumXOR(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int high = 31 - Integer.numberOfLeadingZeros(max);//获取最大值的前置1的位置

        int ans=0,mask=0;//mask起到了记录的作用，不停的记录上次循环中ans
        Set<Integer> set=new HashSet<>();//用来记录保存的重复的值是0还是1
        for (int i = high; i >=0; i--) {
            set.clear();
            int newAns=ans|(1<<i);//这样可以让newAns保证最大，是希望的结果
            mask|=(1<<i);  //这其实就是newAns让第i位之后为0的样子
            for (int num : nums) {
                num&=mask;//让当前这个num的第i位之后的都变成0，i位之前的必须和mask统一才能是1，这样就保证num的大小小于等于原来
                if (set.contains(newAns^num)) {//如果有num1和num2，num1^newAns=num2,这样就可以推出，num1^num2=newAns,也就是第i位可以是1
                    ans=newAns;//刷新ans
                    break;
                }
                set.add(num);
            }//如果if语句一直是false，那ans的第i位一定是0，这时newAns的第i位之后都是0，所有不需要调整
        }
        return ans;

//        作者：灵茶山艾府
//        链接：https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/solutions/2511644/tu-jie-jian-ji-gao-xiao-yi-tu-miao-dong-1427d/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }

}
