package Leecode2;

public class code27_移除元素 {
    public static void main(String[] args) {
        //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
        //
        //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
        //
        //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
        int[]arr={0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
    }
    //双指针
    public static int removeElement(int[] nums, int val) {
        int n=nums.length;
        int res=n;//总长度减去val出现的次数为新数组长度
        int idx=0;//指向下一个不为val的元素
        for (int i = 0; idx < n; i++) {
            while (idx<n&&nums[idx]==val){//维护指针
                idx++;
                res--;
            }
            if (idx<n) nums[i]=nums[idx++];//修正数组
        }
        return res;
    }
}
