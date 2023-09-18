package LeeCode;

public class code2594 {
    public static void main(String[] args) {
        //给你一个整数数组 ranks ，表示一些机械工的 能力值 。
        // ranks[i] 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n^2 分钟内修好 n 辆车。
        //同时给你一个整数 cars ，表示总共需要修理的汽车数目。
        //
        //请你返回修理所有汽车 最少 需要多少时间。
        //注意：所有机械工可以同时修理汽车。
        //ranks = [4,2,3,1], cars = 10      输出：16
        //ranks = [5,1,8], cars = 6         输出：16
        int[] ranks= new int[]{1, 3, 2};
        System.out.println(repairCars(ranks, 1));
    }
    public static long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) ranks[0] * cars * cars; //一个工人维修的时间大于多个工人并行的时间
        while(left < right){
            long mid = left + right >> 1;
            if(check(ranks,cars,mid)){ //能完成，尝试缩小时间
                right = mid;
            } else{   //不能完成，尝试增大时间
                left = mid + 1;
            }
        }
        return left;
    }
    //计算,工人在t时间内能修的车的总和是否大于要修的车数
    private static boolean check(int[] ranks, int cars, long t){
        long count = 0;
        //计算每个工人在 t 时间内完成修复的车辆数量之和
        for(int r : ranks){
            count += (long) Math.sqrt(t/r);
        }
        return count >= cars;
    }

}
