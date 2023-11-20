package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code118_杨辉三角 {
    public static void main(String[] args) {
        //给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
        //
        //在「杨辉三角」中，每个数是它左上方和右上方的数的和。
        System.out.println(generate(3));
    }
    //常规的线性规划
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>res=new ArrayList<>();
        //初始化第一个集合 {1}
        List<Integer> init=List.of(1);
        res.add(init);
        //维护当前要遍历集合的长度
        int size=2;
        while (numRows-->1){
            List<Integer> list1= Arrays.asList(new Integer[size]);//创建定长度的集合
            List<Integer> list = res.get(size - 2);//获取上一行元素
            //按照杨辉三角的规则 根据上一行得到当前行
            list1.set(0,1);
            list1.set(size-1,1);
            for (int i = 0; i < list.size()-1; i++) {
                list1.set(i+1,list.get(i)+list.get(i+1));
            }
            res.add(list1);
            //维护下一个行集合长度
            size++;
        }
        return res;
    }
}
