package LeeCode;

public class code704 {
    public static void main(String[] args) {
        //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    }
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while (r>=l){
            int mid=l+(r-l)/2;
            if (target<nums[mid]){
                r=mid-1;
            }else if (target>nums[mid]){
                l=mid+1;
            }else return mid;
        }
        return -1;
    }
}
