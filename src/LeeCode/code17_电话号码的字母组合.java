package LeeCode;

import java.util.*;

public class code17_电话号码的字母组合 {
    public static void main(String[] args) {
        //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
        //
        //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
        //2: abc
        //3: def
        // ....
        //7: pqrs
        //8: tuv
        //9: wxyz
        String s="23";
        System.out.println(letterCombinations(s));
    }

    //回溯法
    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) return combinations;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    // 结果集  数字映射  初始字符串  初始字符串索引  字符串优化
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {//初始字符串遍历完毕
            combinations.add(combination.toString());
        } else {
            String letters = phoneMap.get(digits.charAt(index));//从映射中获取数字对应的字符串
            for (int i = 0; i < letters.length(); i++) {//遍历添加字符
                combination.append(letters.charAt(i));//先添加当前字符
                backtrack(combinations, phoneMap, digits, index + 1, combination);//进行回溯,也就是在当前字符的基础上重复添加,并在长度达到时停止
                combination.deleteCharAt(index);//添加完毕就删除当前字符,重新下一轮的开始
            }
        }
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/solutions/388738/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



//树的层序遍历,但是中间没有StringBuilder之类的给字符串修改提效,速度慢
public static List<String> letterCombinations(String digits) {
    int len = digits.length();
    List<String> res=new ArrayList<>();
    if (len==0) return res;
    Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    for (int j = 0; j < digits.length(); j++) {
        letterCombinations(digits,phoneMap,res,j);
    }
    return res;
}

    public static void letterCombinations(String digits,Map<Character,String> phoneMap, List<String> res,int idx){
        String s = phoneMap.get(digits.charAt(idx));
        List<String> tmp=new ArrayList<>(res);
        res.clear();
        for (int j = 0; j < s.length(); j++) {
            char c=s.charAt(j);
            if (tmp.size() == 0) res.add(String.valueOf(c));
            for (String val : tmp) {
                res.add(val + c);
            }
        }
    }

}
