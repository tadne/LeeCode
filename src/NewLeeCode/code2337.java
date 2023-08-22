package NewLeeCode;

public class code2337 {
    public static void main(String[] args) {
        //给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
        //
        //字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
        //字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
        //如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。

        // "_L_L_R__R_"; "LL______RR";
        //start = "R_L_", target = "__LR"
        //start = "_R", target = "R_"
        String start= "_R";
        String target="L_";
        System.out.println(canChange(start, target));
    }


    //双指针,就是用i和j将其遍历两遍
    public static boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') i++;//跳过 _
            while (j < n && target.charAt(j) == '_') j++;
            if (i < n && j < n) {
                if (start.charAt(i) != target.charAt(j)) return false;//相等找到不同之处
                char c = start.charAt(i);
                //由于L只能向左移动,所以它掌控了它左边所有的 _ .同理对应R也如此,如此,L出现时了i<j的,R出现i>j
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) return false;
                i++;j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != '_') return false;
            i++;
        }
        while (j < n) {
            if (target.charAt(j) != '_') return false;
            j++;
        }
        return true;
    }

    //将_变成对应的L或R锁定所有的L和R,但是出现的问题是如果刚好没有对应的L或R会出现问题
    public static boolean canChange2(String start, String target) {
        char[] chars = start.toCharArray();
        int vis=-1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='_'&&vis==-1) chars[i]='L';
            else if (chars[i]=='_'&&vis==-2) chars[i]='R';
            else if (chars[i]=='R') {
                vis=-2;
            }else if (chars[i]=='L'){
                vis=-1;
            }
            if (target.charAt(i)=='_') continue;
            else if (target.charAt(i)!=chars[i]) {
                System.out.println(new String(chars));
                return false;
            }
        }
        System.out.println(new String(chars));
        return true;
    }
    //这个方法不能判断移动中的RL,只能判断移动到极限位置的字符串
    //其实这个方法也可以变双指针,修改一下应该也不算难
    public static boolean canChange1(String start, String target) {
        char[] chars = start.toCharArray();
        int l=0;
        int len=chars.length;
        int vis=-1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='_') continue;
            else if (chars[i] == 'R' && i< chars.length-1) {
                l = i + 1;
                if (i<len-1&&chars[i+1]=='_') swap(chars,i,i+1);
                if (chars[i+1]=='R'&&vis==-1) vis=i;
            } else if (chars[i]=='L') {
               swap(chars,i,l);
               l++;
            } else if (vis!=-1) {
                i = vis;
                vis=-1;
            }
        }
        return target.equals(new String(chars));
    }
    public static void swap(char[] chars,int i,int j){
        char temp =chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }



}
