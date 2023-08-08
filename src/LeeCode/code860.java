package LeeCode;

public class code860 {
    public static void main(String[] args) {
        //在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
        //
        //每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
        //
        //注意，一开始你手头没有任何零钱。
        //
        //给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

        //[5,5,10,10,20]
        int[] ints={5,5,10,10,20};
        System.out.println(lemonadeChange(ints));
    }
    public static boolean lemonadeChange(int[] bills) {
        int[] myCounts={0,0,0};
        for (int i = 0; i < bills.length; i++) {
            if (bills[i]==5) myCounts[0]++;//5元就直接收钱
            else if (bills[i]==10) {//10元就找5元
                myCounts[1]++;
                myCounts[0]--;
                if (myCounts[0]<0) return false;
            }else {//20就找3个5元 或 1个10元,1个5元
               myCounts[0]--;
               myCounts[1]--;
               if (myCounts[1]<0){//回滚10元数目
                   myCounts[1]++;
                   myCounts[0]-=2;
               }
                if (myCounts[0]<0) return false;
               myCounts[2]++;
            }
        }
        return true;
    }
}
