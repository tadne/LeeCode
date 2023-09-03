package WeekRace.Week361;

public class code8040 {
    public static void main(String[] args) {
        //8040. 生成特殊数字的最少操作 显示英文描述
        //给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
        //
        //在一次操作中，可以选择 num 的任意一位数字并将其删除。请注意，如果删除 num 中的所有数字，则 num 变为 0。
        //
        //返回最少需要多少次操作可以使 num 变成特殊数字。
        //
        //如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
        //：      num = "2245047"     输出：2
        //输入：   num = "2908305"    输出：3
        //输入：   num = "10"         输出：1
        //解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
        //可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
        // 10       1
        //2245047   2
        //2908305   3
        //51        2
        //820366    5
        //2908305   3
        System.out.println(minimumOperations("2610533"));
    }
    public static int minimumOperations(String num) {
        int n=num.length();
        if (n==1) return 1;
        int res=0;
       loop: for (int i = num.length()-1; i >= 0; i--) {
            if (num.charAt(i)=='0'){
                if (i==0) res++;
                int j=i-1;
                int temp=0;
                while (j>=0){
                    char c=num.charAt(j);
                    if (c=='0'||c=='5') return res+=temp;
                    else temp++;
                    if (j==0) temp--;
                    j--;
                }
            }else if (num.charAt(i)=='5'){
                int j=i-1;
                if (i==0) res++;
                int temp=0;
                while (j>=0){
                    char c=num.charAt(j);
                    if (c=='2'||c=='7') return res+=temp;
                    else if (c=='0') {
                        res++;
                        continue loop;
                    }
                    else if (j==0) res++;
                    else temp++;
                    j--;
                }
            }else res++;
        }
        return res;
    }
}
