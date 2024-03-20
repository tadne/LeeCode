package Leecode2;

public class code169_多数元素 {
    public static void main(String[] args) {
        //给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
        //
        //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    }
    //先固定一个值作为多数元素，遍历数组，遇到相同就记录数量，遇到不同就抵消。剩下的就是多数元素
    public int majorityElement(int[] nums) {
        int res=nums[0];//假设第一个元素是多数元素
        int count=0;
        for (int num : nums) {
            if (num == res) count++;
            else if (count == 0) {
                res = num;
                count++;
            } else count--;
        }
        return res;
    }
}
