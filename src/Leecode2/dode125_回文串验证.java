package Leecode2;

public class dode125_回文串验证 {
    public static void main(String[] args) {
        //如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
        //
        //字母和数字都属于字母数字字符。
        //
        //给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < n && j >= 0 && i <= j; i++, j--) {
            while (i < j && isCharacter(s.charAt(i))) i++;
            while (i < j && isCharacter(s.charAt(j))) j--;
            if (transCharacter(s.charAt(i)) != transCharacter(s.charAt(j))) return false;
            if (i > j) break;
        }
        return true;
    }
    //非字母数字字符返回true
    public static boolean isCharacter(char c) {
        if (c >= 'a' && c <= 'z' || (c >= '0' && c <= '9')) return false;
        else return c < 'A' || c > 'Z';
    }

    public static char transCharacter(char c) {
        if (c >= 'a' && c <= 'z') return c;
        else return (char) (c - 'A' + 'a');
    }

}
