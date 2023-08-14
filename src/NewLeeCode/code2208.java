package NewLeeCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class code2208 {
    public static void main(String[] args) {
        //给你一个正整数数组 nums 。每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半。
        // （注意，在后续操作中你可以对减半过的数继续执行操作）
        //
        //请你返回将 nums 数组和 至少 减少一半的 最少 操作数。
        int[] nums = {5,19,8,1};
        System.out.println(halveArray1(nums));
    }
    public static int halveArray1(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        for (int num : nums) {//放入队列
            pq.offer((double) num);
        }
        int res = 0;
        double sum = 0;
        for (int num : nums) {//获取最大值
            sum += num;
        }
        double sum2 = 0.0;//要减的值
        while (sum2 < sum / 2) {//如果小就可以减
            double x = pq.poll();//出栈并赋值
            sum2 += x / 2;
            pq.offer(x / 2);//一半进栈
            res++;
        }
        return res;
    }

    public int halveArray(int[] nums) {
        Arrays.sort(nums);
        double sum = Arrays.stream(nums).sum();
        double half=sum/2;
        int idx=nums.length-1;
        int res=0;
        while (sum!=half){
            res++;
            double tmp=((double)nums[idx])/2;//减半数
            double sumTmp=sum-tmp;
            if (sumTmp>tmp) {
                sum -= tmp;

                idx--;
            }
            else if (sumTmp==tmp) return res;
            else {
                res--;
                idx--;
            }
        }
        return res;
        
    }
}
