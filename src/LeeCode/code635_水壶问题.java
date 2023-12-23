package LeeCode;

public class code635_水壶问题 {
    public static void main(String[] args) {
        //有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。
        // 确定是否有可能使用这两个壶准确得到 targetCapacity 升。
        //如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
        //
        //你可以：
        //装满任意一个水壶
        //清空任意一个水壶
        //从一个水壶向另外一个水壶倒水，直到装满或者倒空
    }
    //也就是 c==ax+by?  ,其中a是jug1Capacity ,b是jug2Capacity,c是targetCapacity. x和y是变量
    //其中要限制的是 a+b<c,因为水壶不够装targetCapacity就不可能了,这也就是说限制了 x和y不能同时大于1
    // 如果x>=0,y>=0那么显然成立.因为此时就 c=a+b 或者 c=xa 或 c=yb 这三种可能
    // 如果x<0,那就将b装满倒入a,如果b不满把a倒掉,再把b倒入a. 主要是说,要让a中存入 c-b 这么多的水
    //现在来解 c=ax+by,我们可以由贝祖原理知,如果c是a和b的最大公约数的倍数等价于该式子有整数解
    public boolean canMeasureWater(int a, int b, int c) {
        if (a+b<c) return false;
        if (a==0||b==0){
            return c==0||c%(a+b)==0;
        }
        return c%gcd(a,b)==0;
    }
    //寻找最大公约数
    public int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder!=0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/water-and-jug-problem/solutions/161010/shui-hu-wen-ti-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
