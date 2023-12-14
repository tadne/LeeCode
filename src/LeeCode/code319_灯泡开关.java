package LeeCode;

public class code319_灯泡开关 {
    public static void main(String[] args) {
        //初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭第二个。
        //
        //第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。
        //第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
        //
        //找出并返回 n 轮后有多少个亮着的灯泡。
        System.out.println(bulbSwitch1(4));
    }
    public int bulbSwitch(int n) {
        //一开始,灯泡的样子应该是 0000...  其中0表示灭,1表示亮
        //那么接下来的n轮,每 i 个灯泡闪动一次 i=[1,n]
        //那么对于第 k 个灯泡来说, 它的闪动次数应该是它的 它的因子的数量(不包含1和2)
        //但是 数的因子 都是成对出现的, 如果x是a的因子,那么x/a也是a的因子
        //但是 当a是完全平方数的时候, 那么a的因子数就会变成奇数
        //也就是说, 如果k是完全平方数,那么它会有奇数个因子,那么它就会闪奇数次,那么第k个灯泡就会亮
        //也就是我们只要知道了[1-n]中有多少个完全平方数即可
        return (int) Math.sqrt(n);
    }


    // 手写流,但是问题在于会有内存限制
    public static int bulbSwitch1(int n) {
        if (n==1||n==2) return 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i%2==0) sb.append(1);
            else sb.append(0);
        }
        int res = n/2+n%2;
        for (int i = 2; i < n; i++) {
            for (int j = i; j < n; j+=i+1) {
                if (sb.charAt(j)=='0') {
                    sb.replace(j,j+1,"1");
                    res++;
                } else {
                    sb.replace(j,j+1,"0");
                    res--;
                }
            }
        }
        return res;
    }
}
