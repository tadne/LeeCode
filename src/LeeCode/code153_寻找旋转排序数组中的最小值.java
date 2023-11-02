package LeeCode;

public class code153_寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        //已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
        //若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
        //若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
        //注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
        //
        //给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
        //
        //你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
        //4,5,6,7,0,1,2
        int[] arr={3,1,2};
        System.out.println(findMin(arr));
    }
    //就是二分筛选,不过其实下面这个可以优化到两个if
    public static int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        int min=nums[0];
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]<=nums[r]){//如果中间值小于右边,那说明右边都是递增的,不要右边
                min=Math.min(nums[mid],min);
                r=mid-1;
            }else if (nums[mid]>nums[r]){//如果中间值大于右边,那说明左边都是逆转的值都很大,不要左边
                min=Math.min(nums[r],min);
                l=mid+1;
            }else if (nums[mid]>nums[l]){//如果中间值大于左边,那说明左边都是递增的,只取最左边最小值即可,不用左边
                min=Math.min(nums[l],min);
                l=mid+1;
            }else if (nums[mid]<nums[l]){//如果中间值小于左边,那说明右边都是递增的,不要右边
                min=Math.min(nums[mid],min);
                r=mid-1;
            }
        }
        return min;
    }
}
