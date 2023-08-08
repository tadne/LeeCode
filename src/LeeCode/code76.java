package LeeCode;

import java.util.Arrays;

public class code76 {
    public static void main(String[] args) {
        //给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
        //
        //我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
        //
        //必须在不使用库内置的 sort 函数的情况下解决这个问题。
        //int[]nums={0,1,2,2,1,0};
        int[]nums={0,1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    //双指针
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;//双指针
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {//遍历到1
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {//遍历到0
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {//1和0之间交换
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
    //记录数量
    public static void sortColors3(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int zeroNum=0;
        int twoNum=0;
        while (l<=r){
            if (l!=r) {
                if (nums[l] == 0) zeroNum++;
                if (nums[l] == 2) twoNum++;
            }
            if (nums[r]==0) zeroNum++;
            if (nums[r]==2) twoNum++;
            l++;
            r--;
        }
        Arrays.fill(nums,1);
        Arrays.fill(nums,0,zeroNum,0);
        Arrays.fill(nums,nums.length-twoNum,nums.length,2);
    }

    //或者说还是可以执着于记录数量,因为速度快,然后也是一次遍历
    public static void sortColors2(int[] nums) {
        int j=0;
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                k++;
            }
            else if (nums[i]==2) {
                j++;
            }
        }
        Arrays.fill(nums,1);
        Arrays.fill(nums,0,k,0);
        Arrays.fill(nums,nums.length-j,nums.length,2);
        System.out.println(Arrays.toString(nums));
    }




    //感觉创建个数组复制就好了,没想到是不允许创建的
    public static void sortColors1(int[] nums) {
        int[]arr=new int[nums.length];
        Arrays.fill(arr,1);
        int j=0;
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                arr[k] = 0;
                k++;
            }
            else if (nums[i]==2) {
                arr[nums.length - 1 - j] = 2;
                j++;
            }
        }
        nums=arr;
    }



}
