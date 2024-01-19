package LeeCode;

import java.util.HashMap;

public class code13_罗马数字转整数 {
    public static void main(String[] args) {
        //罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
        //
        //字符          数值
        //I : 1     V : 5    X : 10     L : 50
        //C : 100   D : 500     M : 1000
        //如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
        //
        //通常情况下，罗马数字中小的数字在大的数字的右边。
        // 但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
        // 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
        //
        //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
        //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        //给定一个罗马数字，将其转换成整数。
        //"MCMXCIV"输出: 1994  m:1000 cm:900  xc:90  iv:4  1994
        System.out.println(romanToInt("MCMXCIV"));
    }

    //map集合处理
    public static int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1); map.put('V',5); map.put('X',10);map.put('L',50);map.put('C',100);map.put('D',500);map.put('M',1000);
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i<s.length()-1&&map.get(c)<map.get(s.charAt(i+1))){//如果下一个字母代表的数字比当前大,按罗马数字规则要减去小的那个
                res+=map.get(s.charAt(i+1))-map.get(c);
                i++;//跳过下一个
            }else res+=map.get(c);
        }
        return res;
    }

    //直接存方法里,switch查找也可以,这种速度比较快
    public int romanToInt1(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) sum -= preNum;
            else sum += preNum;
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

//    作者：DoneSpeak
//    链接：https://leetcode.cn/problems/roman-to-integer/solutions/39961/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



}

