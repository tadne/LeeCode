package NewLeeCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class code833 {
    public static void main(String[] args) {
        //你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,  targets。
        //
        //要完成第 i 个替换操作:
        //
        //检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
        //如果没有出现， 什么也不做 。
        //如果出现，则用 targets[i] 替换 该子字符串。
        //例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么替换的结果将是 "eeecd" 。
        //
        //所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。
        //
        //例如，一个 s = "abc" ，  indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 和 "bc" 替换重叠。
        //在对 s 执行所有替换操作后返回 结果字符串 。
        //
        //子字符串 是字符串中连续的字符序列。
        //s = "abcd", indices = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]   "eeebffff"
        //s ="vmokgggqzp"   indices =[3,5,1]    sources =["kg","ggq","mo"]targets =["s","so","bfr"] "v bfr s so zp"

        //s ="abcde"  indices =[2,2]  sources =["cde","cdef"]   targets =["fe","f"]  "abfe"
        String s = "abcde";
        int []  indices = {2,2};
        String [] sources = {"bc","cde"};
        String [] targets = {"fe","f"};
        System.out.println(findReplaceString2(s, indices, sources, targets));
    }
    //这个题目,很难受,题目描述让人很烦
    //不过做出来了

    //用map集合保证indices与sources,targets的一致性以及排序
    //然后加和就好了,其实也不算难,就是题目读起来很难受
    public static String findReplaceString2(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder res=new StringBuilder();
        Map<Integer,String[] > map=new HashMap<>();
        int len=s.length();
        for (int i = 0; i < indices.length; i++) {
            if (map.get(indices[i])==null) map.put(indices[i], new String[]{targets[i], sources[i]});
            else map.put(indices[i]+s.length(), new String[]{targets[i], sources[i]});
        }
        for (int i = 0; i < len; i++) {
            String[] temp = map.get(i);
            String[] temp1 = map.get(i+s.length());
            if (temp!=null&&i+temp[1].length()<s.length()+1&&(temp[1].equals(s.substring(i,i+temp[1].length())))){
                res.append(temp[0]);
                i+=temp[1].length()-1;
            }else if (temp1!=null&&i+temp1[1].length()<s.length()+1&&(temp1[1].equals(s.substring(i,i+temp1[1].length())))){
                res.append(temp1[0]);
                i+=temp1[1].length()-1;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();

    }
    public static String findReplaceString1(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder res=new StringBuilder();
        Map<Integer,String > map=new HashMap<>();
        int len=s.length();
        int idx=0;
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i],targets[i]);
        }
        for (int i = 0; i < len; i++) {
            String temp = map.get(i);
            if (temp!=null){
                res.append(temp);
                i+=sources[idx].length();
                idx++;
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();

    }

    //这个方法没法解决indices数组在非升序情况下的字符串长度变动问题,用这个方法解决有点复杂,没有必要
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int div=0;
        for (int i = 0; i < indices.length; i++) {
            int idxI=indices[i]+div;
            if (sources[i].equals(s.substring(idxI,idxI+sources[i].length()))) {
                s = s.substring(0, idxI) + targets[i] + s.substring(idxI + sources[i].length());
            }
            div+=targets[i].length()-sources[i].length();
        }
        return s;
    }
}
