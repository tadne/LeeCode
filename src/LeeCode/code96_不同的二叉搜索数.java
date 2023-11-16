package LeeCode;

import java.math.BigInteger;

public class code96_不同的二叉搜索数 {
    public static void main(String[] args) {
        //给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
       // System.out.println(numTrees(9));
       // test(9);
        //6402373705728000
        //362880

        System.out.println(numTrees(9));
    }
    //首先,我们希望知道,n个节点的二叉树有多少种: h(n)=C(2n,n)/(n+1)=(2(2n+1)/n+2)*h(n-1)  : 这个建议自行搜索
    //然后,我们知道二叉搜索树 等价于 树的中序遍历是有序的
    //这里转折就来了,说过有n个顺序节点, 是否任意树都能变成二叉搜索树?  显然是的
    //举个例子, 假设n个节点的树是空的, 那么显然,只要我们拿n个有序数字按照中序遍历去填充对应节点就能形成二叉搜索树
    //也就是说,n个顺序节点组成的二叉搜索树的数量其实和n个节点的二叉树有多少种是等价问题!!
    public static int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2L * i + 1) / (i + 2);
        }
        return (int) C;
    }

}
