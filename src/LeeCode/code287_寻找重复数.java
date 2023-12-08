package LeeCode;

public class code287_寻找重复数 {
    public static void main(String[] args) {
        //给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
        //假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
        //你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
        //1 <= n <= 10^5
        //nums.length = n + 1
        //1 <= nums[i] <= n
        //nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
    }
    //2,5,9,6,9,3,8,9,7,1
    // 2 9 1 5 3 6 8 7 9 ...
    //双指针
    //  首先,如果存在环,那么fast和slow一定会相遇.
    //          证明: 因为相对速度,快指针相对于慢指针速度为1,也就是说,假设速度1为静止速度,那么没次移动,快指针都相对于慢指针前进一位,所有必定相遇
    //设起点为0,到达环入口距离为a,    在入环后慢指针走过的距离为b,   这些可以得到快指针在环中走了 a+2b的距离.
    //那么快指针和慢指针相遇时就得到  a+b是环的长度的倍数,
    //再由从起点到入口距离为a ,可以得到快指针再走a步就能到交汇点
    //那么就得到:   此时,让起点和指针一起走,一定会相遇在环的入口
    //位运算, x^x=0 0^x=x
    public int findDuplicate(int[] nums) {
        int slow=nums[0],fast=nums[0];
        //先找到起点到入口的距离
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        } while (slow!=fast);
        //新指针从起点出发,在环入口交汇
        slow=nums[0];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
