package LeeCode;

public class code12_整数转罗马数字 {
    public static void main(String[] args) {
        //罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
        //I : 1     V : 5    X : 10     L : 50
        //C : 100   D : 500     M : 1000

        //如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
        //通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
        // 如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
        // 这个特殊的规则只适用于以下六种情况：
        //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
        //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        //给你一个整数，将其转为罗马数字。
        //1994   MCMXCIV
        System.out.println(intToRoman(1994));
    }
    //罗马数字只能表示10000以下的数字,只要将罗马数字能表示的数字找出
    //从大到小排列,先找大的即可
    public static String intToRoman(int num) {
        //将罗马字母能直接表示的数从大到小排序
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {//遍历排序数组
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {//如果比它小,就可以直接减了    如: 3===>III
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) break;
        }
        return roman.toString();
    }
}
