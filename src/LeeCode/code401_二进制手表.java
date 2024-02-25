        package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code401_二进制手表 {
    public static void main(String[] args) {
        // H : 8 4 2 1
        // M : 32 16 8 4 2 1
        System.out.println(readBinaryWatch(1));
    }
    //朴素的枚举法
    //也就是遍历小时[0,11],分钟[0,59]。
    //如果其二进制中1的个数之和为turnOn，那就加入结果集
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans=new ArrayList<>();
        if (turnedOn>=9||turnedOn<=0) return ans;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i)+Integer.bitCount(j)==turnedOn) ans.add(i+":"+(j<10?"0":"")+j);
            }
        }
        return ans;
    }
    //回溯法
    //其实这种内部有循环的回溯法本质就是字典序遍历
    int[] hours = new int[]{1,2,4,8,0,0,0,0,0,0};
    int[] mins = new int[]{0,0,0,0,1,2,4,8,16,32};
    List<String> ans = new ArrayList<>();
    public List<String> readBinaryWatch1(int turnedOn) {
        backTrack(turnedOn, 0, 0, 0);
        return ans;
    }
    void backTrack(int num, int index, int hour, int minute) {
        if (hour > 11 || minute > 59) return;
        if (num == 0) ans.add(hour + ":" + (minute >= 10 ? "" : "0") + minute);
        for (int i = index; i < hours.length; i++) {
            backTrack(num - 1, i + 1, hour + hours[i], minute +mins[i]);
        }
    }

}
