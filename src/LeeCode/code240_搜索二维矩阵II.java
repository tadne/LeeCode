package LeeCode;

import java.util.Arrays;

public class code240_搜索二维矩阵II {
    public static void main(String[] args) {
        //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
        //
        //每行的元素从左到右升序排列。
        //每列的元素从上到下升序排列。
        int [][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };
        System.out.println(binarySearch(matrix[1], 5));
//        System.out.println(searchMatrix1(matrix, 5));
    }
    //z字形查找,比如上面这个矩阵
    //选搜索15 ,如果比15大,就开始看19,如果比15小,就开始看11
    //这样最慢就是时间复杂度就是O(m+n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) y--;
            else x++;
        }
        return false;
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/1062538/sou-suo-er-wei-ju-zhen-ii-by-leetcode-so-9hcx/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    //二分查找
    public static boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            boolean b = binarySearch(ints, target);
            if (b) return true;
        }
        return false;
    }
    public static boolean binarySearch(int[] arr,int target){
        int l=0,r=arr.length-1;
        while (r>=l){
            int mid= l+(r-l)/2;
            if (arr[mid]>target){
                r=mid-1;
            }else if (arr[mid]<target){
                l=mid+1;
            }else return true;
        }
        return false;
    }


}
