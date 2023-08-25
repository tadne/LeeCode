package NewLeeCode;

import java.util.Arrays;
import java.util.Random;


public class code912 {
    public static void main(String[] args) {
        //给你一个整数数组 nums，请你将该数组升序排列。
        int [] ints=new int[]{-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
     //  int[] ints=new int[]{5,12,13,1,424,252,5,4,26,1,10000,1,2,13,1,3413,5,3,46,4,7336,475,78,4,57,84,32,45,2354,23,45,2,5,32,65,23,56,3,6,3,5,634,6,43,5,3};
        sortArray1(ints);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] nums, int left, int right){
        if (left>=right) return;//递归停止条件
        int p=partition1(nums,left,right);//分区
        quickSort(nums,left,p-1);//递归
        quickSort(nums,p+1,right);//递归
    }
    ////单边快排
    public static int partition(int[] nums, int l, int r){
        Random rd=new Random();
        int random =l+ rd.nextInt(r-l+1);//随机值,防止最左边有降序数组导致最左或最右一直有最值
        swap(nums,random,l);
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= pivot) {//重复
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;

    }
    //双边快排
    public static int partition1(int[] nums, int left, int right){
        Random rd=new Random();
        int random =left+ rd.nextInt(right-left+1);//随机值,防止最左边有降序数组导致最左或最右一直有最值
        swap(nums,random,left);
        int pv=nums[left];//基准点
        int i=left+1,j=right;
        while (i<=j){
            while (i<=j&&nums[j]>pv) j--;    //注意,这里必须要先从右查找,因为基准点是在左边,之后会交换i和基准点的位置,会导致将大数据放在了左边
            while (i<=j&&nums[i]<=pv) i++;
            if (i<=j) {
                swap(nums, i, j);
                i++;j--;
            }
        }
        swap(nums,j,left);
        return j;
    }
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }



    //以下是归并排序,感觉这个代码还是挺难懂的,我自己估计写不出这样的归并代码
   static   int[] tmp;
    public static int[] sortArray1(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;//递归停止条件
        //递归划分
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        //递归排序,合并有序数组
        int i = l, j = mid + 1;
        int cnt = 0;//刷新tmp数组索引位置
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) tmp[cnt++] = nums[i++];
            else tmp[cnt++] = nums[j++];
        }
        //平衡左右长度,如:左边遍历完,右边直接插入
        while (i <= mid) tmp[cnt++] = nums[i++];
        while (j <= r)  tmp[cnt++] = nums[j++];
        System.out.println(i+"-------"+j);
        //对nums数组复制值
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }

    //第二种归并排序,  这种归并好理解些,但是效率没那么高
    public static int[] mergeSort(int[] nums){
        int[] temp=new int[nums.length];
        split(nums,0,nums.length-1,temp);
        return nums;
    }
    public static void split(int[] nums,int left,int right,int[] temp){
        //治
        if (left==right) return;
        //分
        int m=(left+right)>>>1;
        split(nums,left,m,temp);
        split(nums,m+1,right,temp);
        //合并
        merge(nums,left,m,temp,m+1,right);
        System.arraycopy(temp,left,nums,left,right-left+1);
    }
    //合并两个有序数组
    public static void merge(int[] nums, int FStart, int FRight ,int[] temp, int SStart,int SRight) {
       //从后往前遍历处理大小
    }


}
