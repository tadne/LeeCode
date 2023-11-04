package LeeCode;

public class code66_二进制求和 {
    public static void main(String[] args) {
        //给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。

        System.out.println(addBinary3("11", "1"));
    }
    public static String addBinary3(String a, String b) {
        int n=a.length(),m=b.length(),len=Math.max(m,n);// a和b的长度,以及其中最大长度
        StringBuilder s= new StringBuilder();//补全其中长度短的二进制字符串,也就是在前面补0
        s.append("0".repeat(Math.abs(m - n)));
        if (n>m) b=s.append(b).toString();
        else a=s.append(a).toString();
        int tail=0;//进位,比如1+1=2,2在二进制中会升位
        StringBuilder res=new StringBuilder();
        while (len-->0){//遍历
            int num= a.charAt(len)-'0'+b.charAt(len)-'0'+tail;
            res.append(num%2);
            tail=num/2;
        }
        if (tail>0) res.append(1);//最后一个进位
        return res.reverse().toString();
    }
    //这波写的有点丑陋了,
    // 优化思路:将长度同步给取消掉并实现相加
    //进一步优化:将相加循环和处理数组循环合并
    public static String addBinary(String a, String b) {
        char[] sums;
        while (a.length()>b.length()) {
            b="0"+b;
        }
        while (b.length()>a.length()){
            a="0"+a;
        }
        sums=new char[a.length()];
        for (int i = sums.length-1; i >= 0; i--) {//相加
            if (a.charAt(i)!=b.charAt(i)) sums[i]='1';
            else if (a.charAt(i)=='0'&&b.charAt(i)=='0') sums[i]='0';
            else sums[i]='2';
        }
        for (int i = sums.length-1; i >= 0; i--) {//再对其中的2和3进行处理
            if (i!=0&&sums[i]=='2') {
                sums[i]='0';
                sums[i-1]++;
            }else if(i!=0&&sums[i]=='3'){
                sums[i]='1';
                sums[i-1]++;
            }else if (i==0){
                if (sums[i]=='2'){
                    sums[i]='0';
                    return "1"+String.valueOf(sums);
                } else if (sums[i]=='3') {
                    sums[i]='1';
                    return "1"+String.valueOf(sums);
                }
            }
        }
        return String.valueOf(sums);
    }

    //这个官方题解,写的太简洁,可读性真的...he tui~~
    //就是一个一个相加,并且做到等于2或3的时候,为下一次相加留1.   复杂度O(n)
    public static String addBinary1(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            //判断是为了避免数组越界
            // -'0' 是为了用int表示数组中值
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));//如果和的结果是2或3就变1或0,不然不变
            carry /= 2;//将carry变或0,如果是1就说明上一位要加1,保留,0就不变
        }
        if (carry > 0) {//处理最大位+1的问题
            ans.append('1');
        }
        ans.reverse();//翻转
        return ans.toString();
    }
    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2));
    }


}
