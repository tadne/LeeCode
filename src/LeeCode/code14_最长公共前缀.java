package LeeCode;

public class code14_最长公共前缀 {
    public static void main(String[] args) {
        //编写一个函数来查找字符串数组中的最长公共前缀。
        //如果不存在公共前缀，返回空字符串 ""。
        //        "flower","flow","flight"
        //        "dog","racecar","car"
        String[] strs={"ab","a"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        if (len == 0) return "";//特殊情况处理
        else if (len==1) return strs[0];

        StringBuilder res=new StringBuilder(strs[0]);//结果集
        for (int i = 1; i < strs.length; i++) {
            if (res.length()>strs[i].length()) //如果当前结果字符串超出要比对的字符串的长度,删除多余的长度
                res.delete(strs[i].length(),res.length());
            for (int j = 0; j < res.length(); j++) {//获取结果集与当前字符串的共同前缀
                if (res.charAt(j)!=strs[i].charAt(j)){
                    res.delete(j, res.length());//如果当前字符不匹配,那就说明
                    break;
                }
            }
        }
        return res.toString();
    }
}
