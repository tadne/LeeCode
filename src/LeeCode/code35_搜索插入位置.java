package LeeCode;

public class code35_搜索插入位置 {
    public static void main(String[] args) {
        //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        //
        //请必须使用时间复杂度为 O(log n) 的算法。
        int [] arr=new int[]{1,3};
        System.out.println(searchInsert(arr, 3));
    }
    //递归形式的二分查找
    public static int searchInsert(int[] nums, int target) {
        int n=nums.length;
        if (target<nums[0]) return 0;
        else if (target>nums[n-1]) return n;
        return   binarySearch(nums,target,0,nums.length-1);
    }
    public  static int binarySearch(int[] nums, int target ,int start ,int end){
        int mid =start+(end-start)/2;
        if (start>=end) {//到达最后
            if (target>nums[start]) return start+1;//最后做判断,如果大了就放它后面,小了就放它前面
            else return start;
        }
        if (target>nums[mid]) return binarySearch(nums,target,mid+1,end);
        else if (target<nums[mid]) return binarySearch(nums,target,start,mid-1);
        else return mid;//找到了
    }
    //直接二分查找,找第一个大于等于 target 的下标
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1, ans = n;//ans设置为n是为了处理tar>数组所有值的情况
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (target < nums[mid]) {
                ans=mid;//如果target<中间值,说明要插入当前位置右边
                end = mid - 1;
            } else if (target>nums[mid]){
                start = mid + 1;
            }else return mid;
        }
        return ans;
    }
}
