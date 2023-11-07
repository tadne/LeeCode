package LeeCode;

public class code9_回文数 {
    public static void main(String[] args) {
        //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        //
        //回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        //
        //例如，121 是回文，而 123 不是。
        System.out.println(isPalindrome(0));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false; //剪枝
        int val=0;
        while (val<=x){
            val=val*10+x%10;//取个位的值转换
            if (val==x||val==(x/=10)) return true;//通过两次对比去除x只有奇数位的问题
        }
        return false;
    }
}
