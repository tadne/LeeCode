package LeeCode;

public class code397_整数替换 {
    public static void main(String[] args) {
        //给定一个正整数 n ，你可以做如下操作：
        //
        //如果 n 是偶数，则用 n / 2替换 n 。
        //如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
        //返回 n 变为 1 所需的 最小替换次数 。
        System.out.println(integerReplacement(7));
    }
    //如果是偶数 ,那么直接/2即可,因为这样其实是让n减小的最快方式
    //如果是奇数,那么要考虑 n+1和n-1 的因子哪个有 2的更高次幂, 例如 7: 7-1和7+1,8是2的3次幂
    //      但是,当n=3的时候,这是特殊情况,3-1-1=1两步到达,(3+1)/2/2要3步
    public static int integerReplacement(int n) {
        int res=0;
        while (n!=1){
            if (n%2==0) {//偶数
                res++;n/=2;
            }else if (n==3){//特殊情况
              return res+2;
            } else {//奇数
                int count=0;
                long tmp1=n+1L,tmp2=n-1;//避免n是int最大值
                while (tmp1%2==0&&tmp2%2==0){
                    tmp1/=2;
                    tmp2/=2;
                    count++;
                }
                if (tmp2%2!=0) {
                    n= (int) tmp1;
                }else n= (int) tmp2;
                res += count;
            }
        }
        return res;
    }
}
