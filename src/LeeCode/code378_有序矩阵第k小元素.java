package LeeCode;

public class code378_有序矩阵第k小元素 {
    public static void main(String[] args) {
        //给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
        //请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
        //
        //你必须找到一个内存复杂度优于 O(n2) 的解决方案。
    }


    //二分查找,
    //其实可以发现,对于这个有序矩阵的任意一个位置的值,它都大于它的左上角矩形里的值,小于左下角矩形的值
    //再进一步,我们知道对于任意一个数,我们都可以再矩阵中画一条线,它的左上部分就是小于它的值,左下部分就是大于它的值
    //取最小的值l=mat[0,0] r=mat[n-1,n-1],来找大于(l+r)/2的数的数量count,如果k>count 让l=count+1即可..
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int l=matrix[0][0],r=matrix[n-1][n-1];
        while (r>l){
            int mid=l+(r-l)/2;
            int num = getCountSmallerMid(mid, matrix, k, n);
            if (k>num){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
    //找到比mid小的数的个数
    //从第一行的右边开始找,遇到比mid小的数就记录数量,往下找下一行,类似锯齿状
    public int getCountSmallerMid(int mid,int[][]matrix,int k,int n){
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num;
    }
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/solutions/311472/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
