package LeeCode;

import java.util.ArrayList;
import java.util.List;

public class code71_简化路径 {
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
        //    /home/         "/../"     "/home//foo/"       "/a/./b/../../c/"   "/..."


        System.out.println(simplifyPath("/"));

    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        List<String> res=new ArrayList<>();//先获取所有有意义的路径
        int idx=0;
        for (int i = 0; i <split.length; i++) {
            if (split[i].equals("."))continue; //遇到(.)就跳过
            else if (split[i].equals("..")){//遇到(..)就删除前一项
                if (idx>=1){
                    res.remove(idx-1);//如果没有前一项,就不操作了
                    idx--;
                }
            }else if (!split[i].equals("")) {//如果不是空字符串就添加
                res.add(split[i]) ;
                idx++;
            }
        }

        int n=res.size();
        if (n==0) return "/";
        //开始拼接,其实可以用StringJoiner来拼接,但是leecode过不去
        StringBuilder sb=new StringBuilder("/");
        for (int i = 0; i < n-1; i++) {
            sb.append(res.get(i));
            sb.append("/");
        }
        sb.append(res.get(n-1));//加上最后一个元

        return sb.toString();
    }

}
