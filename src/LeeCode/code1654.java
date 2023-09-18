package LeeCode;

public class code1654 {
    public static void main(String[] args) {
        //有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
        //跳蚤跳跃的规则如下：
        //
        //它可以 往前 跳恰好 a 个位置（即往右跳）。
        //它可以 往后 跳恰好 b 个位置（即往左跳）。
        //它不能 连续 往后跳 2 次。
        //它不能跳到任何 forbidden 数组中的位置。
        //跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
        //
        //给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，
        // 请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
        System.out.println(2%4);
    }
//我想到作者说的贝祖定理了,但是写起来我是真有点头疼
// 感觉这个题难道还是蛮大的,不应该是middle啊

//        作者：Explorer
//        链接：https://leetcode.cn/problems/minimum-jumps-to-reach-home/solutions/2418306/tan-xin-shen-du-you-xian-sou-suo-by-peac-mdu2/
//        来源：力扣（LeetCode）
//        以下:著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int a, b, x, max;
    boolean[] visited;
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(x == 0) return 0;
        this.a = a; this.b = b; this.x = x;
        max = 2000 + a + b;//最大值题目
        visited = new boolean[max +1];//关于forbidden数组的判断
        for(int pos:forbidden) visited[pos] = true;
        return dfs(a, 0, true);
    }
    int dfs(int cur, int steps, boolean isForward) {
        if (cur < 0 || cur > max || visited[cur])//如果是当前位置<0,或者大于最大值,或者在forbidden中都不能继续下去
            return -1;
        steps++;//步数+1
        if (cur == x) return steps;//到达
        if (isForward) visited[cur] = true;
        int forwardSteps = -1, backwardSteps = -1;//向前|后步数
        int nextForwardPos = cur + a, nextBackwardPos = cur - b;//前后位置
        if (nextBackwardPos >= x) {//后位置>=x
            //继续下一步并且下一步不能向前,只能后退
            if (isForward) backwardSteps = dfs(nextBackwardPos, steps, false);
            //如果是本轮第一次向后,那接下来不能向后,只能向前
            if (backwardSteps == -1) forwardSteps = dfs(nextForwardPos, steps, true);
        } else {
            //
            forwardSteps = dfs(nextForwardPos, steps, true);
            if (forwardSteps == -1 && isForward) backwardSteps = dfs(nextBackwardPos, steps, false);
        }
        return forwardSteps == -1 ? backwardSteps : forwardSteps;
    }
}
