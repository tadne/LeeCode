package Month356;

import java.util.*;
import java.util.stream.Collectors;


//失败了,还没想出来
public class code3 {
    public static void main(String[] args) {
        //你三个字符串 a ，b 和 c ， 你的任务是找到长度 最短 的字符串，且这三个字符串都是它的 子字符串 。
        //如果有多个这样的字符串，请你返回 字典序最小 的一个。
        //
        //请你返回满足题目要求的字符串。
        //
        //注意：
        //"abc""ca"
        //"a"
        //"a"
        //"bca"
        //"aaa"
        //两个长度相同的字符串 a 和 b ，如果在第一个不相同的字符处，a 的字母在字母表中比 b 的字母 靠前 ，那么字符串 a 比字符串 b 字典序小 。
        //子字符串 是一个字符串中一段连续的字符序列。
        String a="a";
        String b="a";
        String c="ba";
        //System.out.println(minimumString(a, b,c));
        System.out.println(getSumStr(a, c));
    }
    public static String minimumString(String a, String b, String c) {
        String[] arr=new String[12];
        String AB = getSumStr(a, b);
        String BA = getSumStr(b, a);
        String AC = getSumStr(a, c);
        String CA = getSumStr(c, a);
        String BC = getSumStr(b, c);
        String CB = getSumStr(c, b);
            arr[0]=getSumStr(AB,c);
            arr[1]=getSumStr(BA,c);
            arr[2]=getSumStr(c,AB);
            arr[3]=getSumStr(c,BA);
            arr[4]=getSumStr(AC,b);
            arr[5]=getSumStr(CA,b);
            arr[6]=getSumStr(b,AC);
            arr[7]=getSumStr(b,CA);
            arr[8]=getSumStr(BC,a);
            arr[9]=getSumStr(a,BC);
            arr[10]=getSumStr(CB,a);
            arr[11]=getSumStr(a,CB);
        Arrays.sort(arr, (o1,o2)->o1.length() - o2.length());
        List<String> list=new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length()==list.get(0).length()) list.add(arr[i]);
        }
        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        return collect.get(0);
    }
    public static   String getSumStr(String a, String b){
        int temp=0;
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int min = Math.min(a.length(), b.length());
        for (int i = 0; i < charsB.length&&temp<charsA.length; i++) {
            if (charsA[charsA.length-1-temp]==charsB[charsB.length-1-i]) temp++;
            else temp=0;
        }
        StringBuilder res= new StringBuilder(a);
        for (int i = temp; i < charsB.length; i++) {
            res.append(charsB[i]);
        }
        return res.toString();
    }
}
