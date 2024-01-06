package LeeCode;

public class code400_第N位数字 {
    public static void main(String[] args) {
        //给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
        //
        //举例: 字符串 1234567891011... 这个字符串的第11位是0
        System.out.println(findNthDigit(1000000000));
    }
    //1 2 3 4 5 6 7 8 9
    //10 11 12 13 14 15 16 17 18 19
    //20 21 22 ..
    //可以注意到,1~9是一位,10~99是二位
    //对于一个区间,1~9或10~99或100~999...
    //如果n在区间中,我们可以知道,它在这个区间的位置为  n-9-90-...
    //再通过确定当前区间的数的位数以及
    public static int findNthDigit(int n) {
        long t=n;//long型处理溢出
        if (t<9) return (int) t;
        long left=0;//记录左边区间的数字总个数
        long num=9;//确定当前数字所在的区间
        int count=1;//记录所在区间的数字的位数
        while (t>num){
            count++;
            t-=num;//t为当前所在区间的具体位置
            num/=(count-1);//当前区间的数字个数
            left+=num;
            num=num*10*count;//下一个区间的数字字母的总个数
        }
        long endNum= t%count!=0?t/count+left+1:t/count+left; //就是确定对应最终具体数字
        long endIdx=  (t-1)%count;//确定n在这个数字的第几位
        String res = String.valueOf(endNum).substring((int) endIdx, (int) (endIdx+1));
        return Integer.parseInt(res);
    }
}
