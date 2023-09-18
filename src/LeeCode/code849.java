package LeeCode;

public class code849 {
    public static void main(String[] args) {
        //给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
        //
        //至少有一个空座位，且至少有一人已经坐在座位上。
        //
        //亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
        //
        //返回他到离他最近的人的最大距离。
        int[] seats={0,1};
        System.out.println(maxDistToClosest(seats));
    }
    //说难不难,但是我写了快一个小时,呜呜呜,大概是今天状态不好吧

    //其实如果用for循环的话,应该能有不错的优化效果
    public static int maxDistToClosest(int[] seats) {//1001
        int l=0,r=0,max=0;//左右指针和最大值
        int len=seats.length;
        while (r<len){
            while (r<len&&seats[r]!=1) r++;//用右指针找1
            if (r==len) max=Math.max(max,r-l-1);//如果到了末尾,就返回右指针到左指针的长度,因为这时要么左指针在右指针旁边,长度为0,要么在比较远,说明数组末尾不是1
            if (seats[l]==0) max=Math.max(max,r-l);//左指针指向0
            max=Math.max(max,(r-l)/2);//左右指针都指向1
            l=r++;//左指针指向下一个1,右指针自增
        }
        return max;
    }

}
