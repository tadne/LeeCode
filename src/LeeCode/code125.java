package LeeCode;

public class code125 {
    public static void main(String[] args) {
        //如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
        //
        //字母和数字都属于字母数字字符。
        //
        //给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
        String s="0P";
        System.out.println(isPalindrome(s));
    }
    //双指针,但其实也可以先取出不合理元素,然后反转对比就好了,那样容易些
    public static boolean isPalindrome(String s) {
        int n=s.length();
        for (int i = 0, j=n-1; i < n&&j>=0&&i<=j; i++,j--) {
            //分别找到左右的合理元素
            while (i<j&&!isCharacter(s.charAt(i))) i++;
            while (i<j&&!isCharacter(s.charAt(j))) j--;
            //比较大小写
            if (transCharacter(s.charAt(i))!=transCharacter(s.charAt(j))) return false;
            if (i>j) break;
        }
        return true;
    }
    //判断不合理元素
    public static boolean isCharacter(char c){
        if (c>='a'&&c<='z'||(c>='0'&&c<='9')) return true;
        else return c >= 'A' && c <= 'Z';
    }
    //将大写字母转换为小写
    public static char transCharacter(char c){
        if (c>='a'&&c<='z') return c;
        else return (char) (c - 'A' + 'a');
    }

}
