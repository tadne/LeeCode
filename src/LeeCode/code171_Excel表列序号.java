package LeeCode;

public class code171_Excel表列序号 {
    public static void main(String[] args) {
        //给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
        //例如：
        //A -> 1
        //B -> 2
        //C -> 3
        //...
        //Z -> 26
        //AA -> 27
        //AB -> 28
        //...
        System.out.println(titleToNumber("AB"));
    }
    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res=0;
        //从前往后遍历,26进制.和我们计算10进制数字一样,如: 1111= (((1*10)+1)*10+1)*10)+1 ,这里就是把10变成了26,其他不变
        for (char c : chars) {
            res*=26;
            res += c-'A'+1;
        }
        return res;
    }
}
