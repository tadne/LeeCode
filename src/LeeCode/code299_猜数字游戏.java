package LeeCode;

import java.util.*;

public class code299_猜数字游戏 {
    public static void main(String[] args) {
        //猜数字（Bulls and Cows）游戏，该游戏规则如下：
        //写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，会给他一个包含下述信息的提示：
        //猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
        //有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
        //给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
        //
        //提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
        //
        //请注意秘密数字和朋友猜测的数字都可能含有重复数字。
        System.out.println(getHint("1122", "0001"));
    }
    //采用数组存储
    public String getHint1(String secret, String guess) {
        int bulls = 0,cows = 0;
        int[] cntS = new int[10],cntG = new int[10];//一个十种数字
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return bulls + "A" + cows + "B";
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/bulls-and-cows/solutions/1088724/cai-shu-zi-you-xi-by-leetcode-solution-q9lz/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }



    //哈希表处理
    public static String getHint(String secret, String guess) {
        Map<Character,Integer> map=new HashMap<>();//存se数字
        List<Character> list=new ArrayList<>();//存gu数字
        int bulls=0,cows=0;
        for (int i = 0; i < secret.length()&&i<guess.length(); i++) {
            if (secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }else {
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
                list.add(guess.charAt(i));
            }
        }
        for (Character c : list) {
            if (map.containsKey(c)&&map.get(c)>0) {
                cows++;
                map.put(c, map.get(c) - 1);
            }
        }
        return bulls+"A"+cows+"B";
    }
}
