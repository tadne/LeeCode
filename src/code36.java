public class code36 {
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //
    //请必须使用时间复杂度为 O(log n) 的算法。

    public static void main(String[] args) {
      int[]  nums = {1, 3, 5, 6};
      int  target = 4;
        System.out.println(searchInsert(nums, target));
    }

   static int searchInsert(int[] nums, int target) {
        int j = nums.length-1;
        int i=0;
        while (j>=i){
            int k=i+(j-i)/2;
            if (target>nums[k]){
                i=k+1;
            }else if (target<nums[k]){
                j=k-1;
            }else return k;
        }
        return i;
    }
    static int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else r=mid-1;
        }
        return l;
    }




}
