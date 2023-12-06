package LeeCode;

public class code278_第一个错误版本 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
    //二分查找
    public static int firstBadVersion(int n) {
        int left=1, right=n,ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)) left=mid+1;
            else{
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }
    //模拟Leecode给出的isBadVersion方法
    static final int bad =4;
    private static boolean isBadVersion(int mid) {
        return mid < bad;
    }
}
