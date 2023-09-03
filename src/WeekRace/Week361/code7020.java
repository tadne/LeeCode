package WeekRace.Week361;

public class code7020 {
    public static void main(String[] args) {
        //给你两个正整数 low 和 high 。
        //
        //对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
        //
        //返回在 [low, high] 范围内的 对称整数的数目 。
        System.out.println(countSymmetricIntegers(1200, 1230));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int count=0;
        for (int i = low; i <= high; i++) {
            String val= String.valueOf(i);
            if (val.length()%2!=0||val.length()<=1) continue;
            else {
                int sum1=0,sum2=0;
                int l=0,r=val.length()-1;
                while (l!=r+1) {
                    sum1+=val.charAt(l)-'0';
                    sum2+=val.charAt(r)-'0';
                    l++;r--;
                }
                if (sum1==sum2) count++;
            }
        }
        return count;
    }
}
