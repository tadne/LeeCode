package Month356;

public class code1 {
    public static void main(String[] args) {
        //公司里共有 n 名员工，按从 0 到 n - 1 编号。每个员工 i 已经在公司工作了 hours[i] 小时。
        //
        //公司要求每位员工工作 至少 target 小时。
        //
        //给你一个下标从 0 开始、长度为 n 的非负整数数组 hours 和一个非负整数 target 。
        //
        //请你用整数表示并返回工作至少 target 小时的员工数。
    }
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int number=0;
        for (int hour : hours) {
            if (hour >= target) number++;
        }
        return number;
    }
}
