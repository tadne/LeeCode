package LeeCode;

import java.util.*;

public class code187_重复的DNA序列 {
    public static void main(String[] args) {
        //DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
        //
        //例如，"ACGAATTCCG" 是一个 DNA序列 。
        //在研究 DNA 时，识别 DNA 中的重复序列非常有用。
        //
        //给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
        //s[i]=='A'、'C'、'G' or 'T'
        String s="AAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }

    //用八个数字 00:A 01:C 10:G 11:T 表示ACGT,让每个 L 位字符串都与一个20位二进制串构成映射
    //一个20位的二进制串可以用一个int整数来表示
    //并且二进制的计算就可以使用位运算作为滑动窗口,优化运算
    //再利用哈希表,将每个数字放入并计算次数,次数为2就加入结果
    static final int L = 10;
    Map<Character, Integer> bin = new HashMap<>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if (n <= L) return ans;
        int x = 0;
        for (int i = 0; i < L - 1; i++) {//准备前十位的二进制串的整数形式
            x = (x << 2) | bin.get(s.charAt(i));//左移两位为0123空出两个bit位,并加入对应值
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= n - L; ++i) {
            x = (x << 2 | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);//添加字符串下一个元,并将左边的元删除
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) ans.add(s.substring(i, i + L));
        }
        return ans;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/repeated-dna-sequences/solutions/1035568/zhong-fu-de-dnaxu-lie-by-leetcode-soluti-z8zn/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



    //用哈希表映射字符串第一个字母,再查找,不过效率不高,可以通过嵌套映射查找第二个字母..提高效率
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> res=new HashSet<>();
        int len=s.length();
        if (len<=10) return new ArrayList<>();
        Map<Character, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < len-9; i++) {
            char c=s.charAt(i);
            if (map.containsKey(c)){
                map.get(c).add(i);
            }else {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(c,list);
            }
        }
        dfs(map, res, s, 0);
        return res.stream().toList();
    }
    public static void dfs(Map<Character, List<Integer>> map, Set<String> res, String s, int idx){
        if (idx==s.length()-10) return;
        List<Integer> list = map.get(s.charAt(idx));
        String src=s.substring(idx,idx+10);
        if (res.contains(src)){
            list.add(idx);
            dfs(map,res,s,idx+1);
            return;
        }
        for (Integer integer : list) {
            if (integer==idx) continue;
            if (src.equals(s.substring(integer,integer+10))){
                res.add(src);
                break;
            }
        }
        dfs(map,res,s,idx+1);
    }




}
