package NewLeeCode;

import java.util.Arrays;

public class code344 {
    public static void main(String[] args) {
        //编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
        //
        //不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
        char[] s={'a'};
        reverseString(s);
        System.out.println(Arrays.toString(s));

    }
    public static void reverseString(char[] s) {
        int l=0;
        int r=s.length-1;
        while (r>l){
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }
}
