package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code412_FizzBuzz {
    public static void main(String[] args) {
        //给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
        //
        //answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
        //answer[i] == "Fizz" 如果 i 是 3 的倍数。
        //answer[i] == "Buzz" 如果 i 是 5 的倍数。
        //answer[i] == i （以字符串形式）如果上述条件全不满足。
    }
    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean flag1=i%3==0;
            boolean flag2=i%5==0;
            if (flag1&&flag2) res.add("FizzBuzz");
            else if (flag1) res.add("Fizz");
            else if (flag2) res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }
}
