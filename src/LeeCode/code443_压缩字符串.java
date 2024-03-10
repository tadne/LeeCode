package LeeCode;

import java.util.*;

public class code443_压缩字符串 {
    public static void main(String[] args) {
        //给你一个字符数组 chars ，请使用下述算法压缩：
        //
        //从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
        //
        //如果这一组长度为 1 ，则将字符追加到 s 中。
        //否则，需要向 s 追加字符，后跟这一组的长度。
        //压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
        //
        //请在 修改完输入数组后 ，返回该数组的新长度。
        //
        //你必须设计一个只使用常量额外空间的算法来解决此问题。
        //1 <= chars.length <= 2000
        //chars[i] 可以是小写英文字母、大写英文字母、数字或符号
        System.out.println(compress(new char[]{'a','a','a','b','b','a','a'}));
    }
    public static int compress1(char[] chars) {
        int idx = 0,num = 1;
        int len=chars.length;
        for (int i = 1; i <= len; i++) {
            if (i < len && chars[i] == chars[i - 1]) {
                num++;
            } else {
                chars[idx++] = chars[i - 1];//覆盖之前的字母
                if (num > 1) {//数字填充
                    char[] countChars = String.valueOf(num).toCharArray();
                    for (char c : countChars) {
                        chars[idx++] = c;
                    }
                }
                num = 1;
            }
        }
        return idx;
    }
    //复杂版
    public static int compress(char[] chars) {
        int idx=0;
        int len=chars.length;
        for (int i = 0; i < len; ) {
            int j=1;
            chars[idx]=chars[i];
            idx++;
            while (i+j<len&&chars[i]==chars[i+j]){
                j++;
            }
            i+=j;
            if (j==1) continue;
            List<Character> list=new ArrayList<>();
            while (j>0){
                list.add((char)(j%10+'0'));
                j/=10;
            }
            for (int k = list.size()-1; k >= 0; k--) {
                chars[idx++]=(char)(list.get(k));
            }
        }
        System.out.println(Arrays.toString(chars));
        return idx;
    }
}
