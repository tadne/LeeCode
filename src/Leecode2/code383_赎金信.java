package Leecode2;

public class code383_赎金信 {
    public static void main(String[] args) {
        //给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
        // 由小写英文字母组成
        //如果可以，返回 true ；否则返回 false 。
        //
        //magazine 中的每个字符只能在 ransomNote 中使用一次。
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (arr[ransomNote.charAt(i)-'a']--==0){
                return false;
            }
        }
        return true;
    }
}
