package LeeCode;

public class code137_只出现一次的数字II {
    public static void main(String[] args) {
        //给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
        //
        //你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
        System.out.println(0^0);
    }
    // 膜3加法
    // 因为每个bit位不是0就是1,数字出现3次说明,一个bit位所有数的bit位相加会是3的倍数+1或3的倍数
    // 也就是说,如果每次加到3就变0的话,最终会留下唯一数的bit位
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt1 = 0;
            for (int x : nums) {
                int mob = x >> i;//右移让最右边数字就是那个bit位
                int bit = mob & 1;//用&运算获取到 最右边数字
                cnt1 += bit;//相加
            }
            int tru = cnt1 % 3;//结果答案的真实bit位上的数字
            int val = tru << i;//左移到它应该在位置
            ans |= val;//或运算,因为ans和val的位来看,不是0位只可能对应0  : 0|0=0 1|1=1 0|1=1
        }
        return ans;
    }
    //以上算法,说到底就是让bit位: 0->1->2->0...
    //有0,1,2三个数字,bit位又是最小操作单位
    //所以我们可以使用两个bit位去表示三个数字: (00):0  (01):1  (10):2
    //用以下算法去实现这个变化,即bit为0时,ab不变.bit为1时,ab按照上述逻辑变
    public int singleNumber1(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            b =  b ^ x & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
//    作者：灵茶山艾府
//    链接：https://leetcode.cn/problems/single-number-ii/solutions/2482832/dai-ni-yi-bu-bu-tui-dao-chu-wei-yun-suan-wnwy/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
