package LeeCode;

public class code394_字符串解码 {
    public static void main(String[] args) {
        //给定一个经过编码的字符串，返回它解码后的字符串。
        //
        //编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
        //
        //你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
        //此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
        String s = "4[2[jk]e1[f]]";//"yypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
        System.out.println(decodeString(s));
        System.out.println("jkjkefjkjkefjkjkefjkjkef");//yypqjkjkefjkjkefjkjkefjkjkef
    }

    //有记忆的深度搜索

    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        return decodeString(chars,0,0);
    }

    //每次搜索需要的参数:
    //  数组:
    //  深度: 来自上次搜索
    //  本次搜索的重复次数:  来自上次搜索
    static int newIdx =0;//记录深度搜索的深度,也就是索引
    public static String decodeString(char[] chars,int idx,int count) {
        int newCount=0;//记忆接下来的搜索的要重复的次数
        StringBuilder res=new StringBuilder();//本次搜索的结果集合
        for (int i = idx; i < chars.length; i++) {
            char c=chars[i];
            if (c>='0'&&c<='9'){//确定本次搜索的重复次数
                newCount=(c-'0')+newCount*10;
            } else if (c=='['){//进入更深处搜索
                String s = decodeString(chars, i + 1,newCount);
                i= newIdx;//刷新深度,避免回溯
                res.append(s);//添加本次搜索的结果
                newCount=0;//刷新重复次数
            }else if (c>='a'&&c<='z'){
                res.append(c);
            }else if (c==']'){//结束搜索
                newIdx =i;//记忆本次搜索的深度
                //按照重复次数重复添加
                String tmp = res.toString();
                for (int j = 1; j < count; j++) {//添加count-1次
                    res.append(tmp);
                }
                return res.toString();
            }
        }
        return res.toString();
    }



}
