package NewLeeCode;

import java.util.Arrays;

public class code283 {
    public static void main(String[] args) {
        //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        //
        //请注意 ，必须在不复制数组的情况下原地对数组进行操作。
        int [] nums= {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
    //双指针
    public static void moveZeroes(int[] nums) {
        if (nums.length==1) return;
        int r=1;
        int l=0;
        while (r<nums.length&&l<nums.length){
            if (nums[l]==0){//左为0找右
                if (nums[r]!=0){//右不为0交换
                    nums[l]=nums[r];
                    nums[r]=0;
                    l++;
                    r++;
                }else r++;//右为0再找后一个
            }else {//左不为0
                l++;
                r++;
            }
        }
    }
}
