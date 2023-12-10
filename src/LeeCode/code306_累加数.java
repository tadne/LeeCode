package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code306_累加数 {
    public static void main(String[] args) {
        //累加数 是一个字符串，组成它的数字可以形成累加序列。
        //
        //一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
        //
        //给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
        //
        //说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
    }
    int n;
    //没错,就是暴力搜索
    public boolean isAdditiveNumber(String num) {
        n = num.length();
        for (int secondStart = 1; secondStart < n - 1; secondStart++) {//遍历解决两个初始数字的长度问题
            if (num.charAt(0) == '0' && secondStart != 1) break;//如果第一个数字是0,并且第二个数字的起始位置不是1,比如"001"这种情况
            for (int secondEnd = secondStart; secondEnd < n - 1; secondEnd++) {
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) break;//如果第二个数字是0,并且第二个数字的长度不是1,比如"000"这种情况
                if (valid(secondStart, secondEnd, num)) return true;
            }
        }
        return false;
    }
    //开始按照累加规则校验
    public boolean valid(int secondStart, int secondEnd, String num) {
        int firstStart = 0, firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);//第三个数字,采用字符串加法来避免大整数溢出
            int thirdStart = secondEnd + 1, thirdEnd = secondEnd + third.length();//第三个数字的索引起始位置
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {//如果第三个数字不符号累加规则
                break;
            }
            if (thirdEnd == n - 1) {//如果这个数字是符合累加规则的最后一个数字
                return true;
            }
            //调整右移索引,让第一个数字索引变成第二个,第二个变成第三个
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }
    //字符串加法,避免大整数溢出
    public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuilder third = new StringBuilder();
        int carry = 0, cur = 0;//carry是进位值,cur是当前计算的值
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) cur += s.charAt(firstEnd--) - '0';
            if (secondEnd >= secondStart) cur += s.charAt(secondEnd--) - '0';
            carry = cur / 10;
            cur %= 10;
            third.append((char) (cur + '0'));
        }
        return third.reverse().toString();
    }
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/additive-number/solutions/1200446/lei-jia-shu-by-leetcode-solution-cadc/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
