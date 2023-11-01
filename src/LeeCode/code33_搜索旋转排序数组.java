package LeeCode;

public class code33_搜索旋转排序数组 {
    public static void main(String[] args) {
        //整数数组 nums 按升序排列，数组中的值 互不相同 。
        //
        // 传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
        // 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
        // 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
        //
        //给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
        //
        //你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
        int[] arr={3,1};
        System.out.println(search(arr, 0));
    }
    public static int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    //用二分法，但是要做一个预判断进行递归划分
    public static int binarySearch(int[]arr,int tar,int left,int right){
        if (left<=right&&arr[left]>arr[right]) {//如果left<=right并且出现了逆序 ,left<=right是保证不越界
            int mid=left+(right-left)/2;
            if (arr[mid]==tar) return mid;//如果mid位置刚好是target,就直接返回, 否则就要将左右两边都进行搜寻
            int i = binarySearch(arr, tar, left, mid-1);//搜寻左边
            if (i!=-1) return i;//找到就返回,没找到就继续搜寻右边
            return binarySearch(arr, tar, mid+1, right);//搜寻右边,直接返回,因为这次没找到就是没有了
        }
        while (left<=right){
            int mid=left+(right-left)/2;
            if (arr[mid]>tar) right=mid-1;
            else if (arr[mid]<tar) left=mid+1;
            else return mid;
        }
        return -1;
    }
}
