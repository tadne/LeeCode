package LeeCode;

import java.util.HashMap;

public class code205_同构字符串 {
    public static void main(String[] args) {
        //给定两个字符串 s 和 t ，判断它们是否是同构的。
        //
        //如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
        //
        //每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
        String s="foo";
        String t="bar";
        System.out.println(isIsomorphic(s, t));
    }
    //两个map同时遍历,保证一对一
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> st=new HashMap<>();
        HashMap<Character,Character> ts=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character put = st.put(s.charAt(i), t.charAt(i));//获取的是上一个s对应的元素
            Character put1 = ts.put(t.charAt(i), s.charAt(i));//获取的是上一个s对应的元素
            if (put!=null&&put!=t.charAt(i)||put1!=null&&put1!=s.charAt(i)){//比较上一个和现在的区别
                return false;
            }
        }
        return true;
    }
}
