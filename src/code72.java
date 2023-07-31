import java.util.Arrays;

public class code72 {
    public static void main(String[] args) {
        //给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
        //
        //在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
        // 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
        //
        //请注意，返回的 规范路径 必须遵循下述格式：
        //
        //始终以斜杠 '/' 开头。
        //两个目录名之间必须只有一个斜杠 '/' 。
        //最后一个目录名（如果存在）不能 以 '/' 结尾。
        //此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
        //返回简化后得到的 规范路径 。
        //    /home/         "/../"     "/home//foo/"       "/a/./b/../../c/"


        System.out.println(simplifyPath2("/a/../../b/../c//.//"));

    }
    //没搞出来,明天继续想想这个题
    public static String simplifyPath2(String path) {
        char[] chars = path.toCharArray();
        String[] split = path.split("/");//["", "a", ".", "b", "..", c,""]
        String[] res=new String[path.length()+1];
        Arrays.fill(res,"");
        res[0]="/";


        return Arrays.toString(res);
    }
    public static String simplifyPath1(String path) {
        char[] chars = path.toCharArray();
        String[] split = path.split("/");//["", "a", ".", "b", "..", c,""]
        StringBuilder res= new StringBuilder("/");
        String temp="";

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(""))  continue;
            else if (!split[i].startsWith(".")&&!split[i].equals("")) {
                res.append(split[i]);
                res.append("/");
                temp=split[i];
            }
            else if (split[i].equals(".")) continue;
            else if (split[i].equals("..")) {
                res.delete(res.length() - 1 - temp.length(), res.length());
            }
        }
        if (res.length()>0&&res.charAt(res.length()-1)=='/') res.delete(res.length()-1,res.length());
        if (res.length()==0) res.append("/");
        return res.toString();
    }
    public static String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        String[] split = path.split("/");


        StringBuilder res= new StringBuilder();
        if (path.charAt(0)!='/') path="/"+path;//始终以斜杠 '/' 开头。
        for (int i = 0; i < chars.length; i++) {
            if (i>=1&&path.charAt(i)=='/'&&path.charAt(i-1)=='/'){//两个目录名之间必须只有一个斜杠 '/' 。
                continue;
            }
            if (i<path.length()-1&&path.charAt(i)=='.'&&path.charAt(i+1)=='/')i++;//    防止./的情况
            if (i<path.length()-1&&path.charAt(i)=='.'&&path.charAt(i+1)=='.') {
                i += 2;
                continue;
            };//   防止../的情况
            if (i==path.length()-1&&res.length()>=2&&path.charAt(i)=='/') continue;//最后一个目录名（如果存在）不能 以 '/' 结尾。
            res.append(path.charAt(i));
        }


        return res.toString();
    }
}
