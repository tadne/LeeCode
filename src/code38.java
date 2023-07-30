public class code38 {
    public static void main(String[] args) {
        //给定一个正整数 n ，输出外观数列的第 n 项。
        //
        //「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
        //
        //你可以将其视作是由递归公式定义的数字字符串序列：

        int n=3;
       String s = countAndSay(n);
      System.out.println(s);

       //System.out.println(getCount("1"));
    }
    public static String countAndSay(int n) {
        if (n==1){
            return "1";
        }
        String str="11";
        if (n==2){
            return str;
        }
        for (int i = 0; i < n-1; i++) {
            String result = getCount(str);
            str=result;
        }
        return str;
    }
    public static String getCount(String str){
        StringBuilder result= new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len-1;i++) {//遍历
            int temp=1;//计数器
            while (i<len-1&&str.charAt(i)==str.charAt(i+1)){//相同数字的描述
               temp++;
               i++;
           }
           if (temp!=1){//如果说有连续相同数字，个数为temp个，数字为第i个数字
               result.append(temp).append(str.charAt(i));
           }
           if (temp==1)//如果不相同就用1加
            result.append(1).append(str.charAt(i));//不同数字前面加1
            if (i==len-2){//如果是倒数第二个就直接把最后一个加上就完了
                result.append(1).append(str.charAt(i+1));
            }
        }
        return result.toString();
    }



}
