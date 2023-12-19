package LeeCode;

import java.util.Arrays;

public class code338_比特位计数 {
    public static void main(String[] args) {
        //给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
        System.out.println(Arrays.toString(countBits(5)));
    }
    //可以注意到, 0~3: 00,01,10,11
    //4~7: 100, 101, 110, 111
    //8~15: 1000,1001,1010,1011,1100,1101,1110,1111
    //可以发现,前 4x个数字与后4x个数字的1的数量其实就多一个的关系
    public static int[] countBits(int n) {
        int[]ans=new int[n+1];
        //初始化前4个数  0123 中的1的个数
        if (n==0) return ans;
        if (n>=1) ans[1]=1;
        if (n>=2) ans[2]=1;
        if (n>=3) ans[3]=2;
        //开始循环遍历前4x个元素
        int mul=4;
        for (int i = 4; i < n+1; ) {
            for (int j = 0; j < mul && j<n+1&&i<n+1; j++) {
                ans[i++]=ans[j]+1;
            }
            mul*=2;
        }
        return ans;
    }
}
