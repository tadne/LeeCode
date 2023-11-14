package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code89_格雷编码 {
    public static void main(String[] args) {
        //n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
        //每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
        //第一个整数是 0
        //一个整数在序列中出现 不超过一次
        //每对 相邻 整数的二进制表示 恰好一位不同 ，且
        //第一个 和 最后一个 整数的二进制表示 恰好一位不同
        //给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
        //0231547
        // 000 010 011 001 101 100 110 111
    }
    //可以使用Gn-1构造出 n位的格雷码序列 Gn。具体的方法如下：
    //我们将 Gn−1复制一份并翻转，记为  Gn−1T ,给 Gn−1T 中的每个元素的第 n−1 个二进制位都从 0 变为 1，得到 (Gn−1T)′
    // 这里最低的二进制位为第 0个二进制位
    // 我们将 Gn−1和 (G_{n-1}^T)'进行拼接，得到 Gn
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/gray-code/solutions/1196538/ge-lei-bian-ma-by-leetcode-solution-cqi7/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {//遍历n次集合中的元素
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {//每次遍历都会让集合中的数字翻转,并使得第i-1个进制位变为1
                int tmp = ret.get(j) | 1 << (i - 1);
                ret.add(tmp);
            }
        }
        return ret;
    }
}
