package Leecode2;

public class code167_两数之和II_输入有序数组 {
    public static void main(String[] args) {
        //给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
        //请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
        // 则 1 <= index1 < index2 <= numbers.length 。
        //
        //以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
        //
        //你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
        //
        //你所设计的解决方案必须只使用常量级的额外空间。
    }
    //数学、左右指针
    //就是如果左右指针相加
    //  小于tar，说明左指针必须向右，因为右指针已经最大了
    //  大于tar，说明右指针必须向左，因为左指针已经最小了
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while (r>l){
            int sum=numbers[l]+numbers[r];
            if (sum>target) r--;
            else if (sum<target) l++;
            else return new int[]{l+1,r+1};
        }
        return null;
    }
}
