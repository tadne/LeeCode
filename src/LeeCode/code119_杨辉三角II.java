package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code119_杨辉三角II {
    public static void main(String[] args) {
        //给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
        //
        //在「杨辉三角」中，每个数是它左上方和右上方的数的和。
    }
    //我们知道杨辉三角就是组合数
    //那么我们只要知道了同一行的组合数的递推公式,就可根据该行的第一个元素递推出该行所有元素
    //C(m,n)=(m!)/(m!(n-m)!)
    //所以有C(m,n)=C(m-1,n)*(n-m+1)/m
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/pascals-triangle-ii/solutions/601082/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
