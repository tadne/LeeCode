package NewLeeCode;

public class code415 {
    public static void main(String[] args) {
        //给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
        //
        //你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
        String s="6994";
        String s1="36";
        System.out.println(addStrings(s, s1));
    }

    public static String addStrings1(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
    //丑陋版
    public static String addStrings(String num1, String num2) {
        if (num2.length()>num1.length()) {//交换,让字符串更长的放前面
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        int idx1=num1.length()-1;
        int idx2=num2.length()-1;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int carry=0;
        while (idx2>=0){//加和
            int sum = chars1[idx1] + chars2[idx2]-2*'0'+carry;
            chars1[idx1]= (char) ((sum%10)+'0');
            carry=sum/10;
            idx1--;
            idx2--;
            if (idx2==-1&&carry!=0&&idx1>=0) {
                chars1[idx1]+=carry;
                if (chars1[idx1]>'9') {
                    carry = 1;
                    chars1[idx1]='0';
                }else  return new String(chars1);
            }
        }
        while (carry>0&&idx1>0){//处理最后项
            chars1[idx1-1]++;
            if (chars1[idx1-1]>'9') {
                chars1[idx1-1]='0';
            }else carry=0;
            idx1--;
        }
        if (carry!=0) return "1"+new String(chars1);
        return new String(chars1);
    }
}
