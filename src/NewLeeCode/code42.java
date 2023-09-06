package NewLeeCode;

public class code42
{
    public static void main(String[] args) {
        //给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
        //
        //注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。

        String a="123456789";
        String b="987654321";
        System.out.println(multiply(a, b));

    }
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {//特殊值0排除
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];//num1*num2的位数是二者的长度之和
        for (int i = num1.length() - 1; i >= 0; i--) {//遍历
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                //竖式计算，当前两位乘积的结果是一个两位数
                //还要加上上一次运算的十位数
                //个位数在第i+j位，十位数在第i+j+1位
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        //拼接
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;//因为十位数可能为0，如2*3=06，故排除
            result.append(res[i]);
        }
        return result.toString();
    }
}




