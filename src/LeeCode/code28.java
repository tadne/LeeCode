package LeeCode;

public class code28 {
    public static void main(String[] args) {
        //给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
        // 如果 needle 不是 haystack 的一部分，则返回  -1 。
        String s="hello";
        String s1="ll";
        System.out.println(strStr(s, s1));
    }
    //先遍历,中间用双指针加快速度
    public static int strStr(String haystack, String needle) {
        int hLen=haystack.length(),nLen=needle.length();
        for (int i = 0; i < hLen-nLen+1; i++) {
            int l=i,r=i+nLen-1;//双指针
            for (int j = 0,j1=nLen-1;j1>=j; j++,j1--,l++,r--) {//用四个参数作为四个指针分别执行两个字符串的两端,(其实这里是可以简化的)
                if (haystack.charAt(l)!=needle.charAt(j)||haystack.charAt(r)!=needle.charAt(j1)) break;//如果不匹配就停
                else if (j1<=j||j1==j+1) return i;//如果指针相遇就对了
            }
        }
        return -1;
    }
}
