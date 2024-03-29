package Leecode2;

public class code13_罗马数字转整数 {
    public static void main(String[] args) {
        //罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
        //
        //字符          数值
        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000
        //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
        //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        //给定一个罗马数字，将其转换成整数。
        System.out.println(romanToInt("MCMXCIV"));
    }
    //数组存映射
    public static int romanToInt(String s) {
        int[] arr=new int[26];
        arr['I'-'A']=1;
        arr['V'-'A']=5;
        arr['X'-'A']=10;
        arr['L'-'A']=50;
        arr['C'-'A']=100;
        arr['D'-'A']=500;
        arr['M'-'A']=1000;
        int pre=0;
        int sum=0;
        int len=s.length();
        //如果是前后映射的大小有逆序，说明出现4或者9，减去逆序的数即可
        for (int i = 0; i < len-1; i++) {
            int c=s.charAt(i)-'A';
            if (arr[c]<arr[s.charAt(i+1)-'A']) sum-=arr[c];
            else sum+=arr[c];
        }
        sum+=arr[s.charAt(len-1)-'A'];
        return sum;
    }
}
