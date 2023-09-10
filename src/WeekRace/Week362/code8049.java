package WeekRace.Week362;

public class code8049 {
    public static void main(String[] args) {
        //8049. 判断能否在给定时间到达单元格 显示英文描述
        //给你四个整数 sx、sy、fx、fy  以及一个 非负整数 t 。
        //在一个无限的二维网格中，你从单元格 (sx, sy) 开始出发。每一秒，你 必须 移动到任一与之前所处单元格相邻的单元格中。
        //如果你能在 恰好 t 秒 后到达单元格 (fx, fy) ，返回 true ；否则，返回  false 。
        //单元格的 相邻单元格 是指该单元格周围与其至少共享一个角的 8 个单元格。你可以多次访问同一个单元格。
        //1 <= sx, sy, fx, fy <= 109
        //0 <= t <= 109
        System.out.println(isReachableAtTime(1, 2, 1, 2, 1));
    }
    //当t不为1时，可以到达t长度内的任意地方
    //当t是1时，不能停留在原地
    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int subX= Math.abs(sx-fx);
        int subY= Math.abs(sy-fy);
        int min=Math.max(subX,subY);
        if (t<min) return false;
        else if (sx==fx&&sy==fy) return t!=1;
        return true;
    }
}
