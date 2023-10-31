package LeeCode;

public class code74_搜索二维矩阵 {
    public static void main(String[] args) {
        //给你一个满足下述两条属性的 m x n 整数矩阵：
        //
        //每行中的整数从左到右按非严格递增顺序排列。
        //每行的第一个整数大于前一行的最后一个整数。
        //给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
        int[][]arr={{1,3}};
        System.out.println(searchMatrix(arr, 3));
    }
    //两层二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix[0].length;
        int i = binarySearchArr(matrix, target);
        if (i==-1) return false;
        else  return binarySearch(matrix[i], target);
    }
    public static boolean binarySearch(int[] arr,int tar){
        int l=0,r=arr.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (arr[mid]>tar){
                r=mid-1;
            }else if (arr[mid]<tar){
                l=mid+1;
            }else return true;
        }
        return false;
    }
    public static int binarySearchArr(int[][] arr,int tar){
        int l=0,r=arr.length-1,n=arr[0].length;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (arr[mid][0]>tar){
                r=mid-1;
            }else if (arr[mid][n-1]<tar){
                l=mid+1;
            }else return mid;
        }
        return -1;
    }
}
