package LeeCode;

public class code389_找不同 {
    public static void main(String[] args) {
        //给定两个字符串 s 和 t ，它们只包含小写字母。
        //
        //字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
        //
        //请找出在 t 中被添加的字母。
        String s="abcd";
        String t="abcde";
        System.out.println(findTheDifference(s, t));
    }
    //求和
    public static char findTheDifference1(String s, String t) {
        int res=0;
        for (char c : t.toCharArray()) {
            res+=c;
        }
        for (char c : s.toCharArray()) {
            res-=c;
        }
        return (char) res;
    }
    //计数
    public static char findTheDifference(String s, String t) {
        int n = s.length();
        int[]arr=new int[26];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < n+1; i++) {
            char c=t.charAt(i);
            if (arr[c-'a']!=0) arr[c-'a']--;
            else return c;
        }
        return '0';
    }
}
