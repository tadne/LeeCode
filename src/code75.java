public class code75 {
    public static void main(String[] args) {
        //给你一个满足下述两条属性的 m x n 整数矩阵：
        //
        //每行中的整数从左到右按非递减顺序排列。
        //每行的第一个整数大于前一行的最后一个整数。
        //给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。

        int[]arr={3,4,4,5};
        System.out.println(binarySearch(arr, 5));


    }

    //优化思路,将二维数组也第一列也做成二分查找的形式
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (i<matrix.length-1&&target>matrix[i][0]&&target<matrix[i+1][0]){
                return binarySearch(matrix[i],target);
            }else if (target==matrix[i][0]) return true;
            else if (i==matrix.length-1) return binarySearch(matrix[i],target);
        }
        return false;
    }

    //二分查找
    public static boolean binarySearch(int [] arr,int target){
        int l=0;
        int r=arr.length-1;
        while (l<=r){
            int mid =l+(r-l)/2;
            if (target>arr[mid]) l=mid+1;
            else if (target<arr[mid]) r=mid-1;
            else return true;
        }
        return false;
    }


}
