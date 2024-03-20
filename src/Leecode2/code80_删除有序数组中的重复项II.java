package Leecode2;

public class code80_删除有序数组中的重复项II {
    public static void main(String[] args) {
        //给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
        //
        //不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    }
    //一个指针指向要修改的值，另一个指针遍历数组跳过重复两次以上的值
    public int removeDuplicates(int[] nums) {
        int idx=0;//指向当前要修改的位置
        for (int i = 0; i < nums.length; i++) {
            //idx<2: 前两个元素直接赋值，即nums[0]=nums[0],nums[1]=nums[1]
            //nums[i]>nums[i-2]: 如果出现超过两次重复，就赋值，不然跳过
            if (idx<2||nums[i]>nums[idx-2]){
                nums[idx++]=nums[i];
            }
        }
        return idx;
    }
}
